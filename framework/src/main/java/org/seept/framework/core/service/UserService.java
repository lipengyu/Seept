package org.seept.framework.core.service;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.seept.framework.core.entity.Role;
import org.seept.framework.core.entity.User;
import org.seept.framework.core.entity.UserRole;
import org.seept.framework.core.repository.RoleDao;
import org.seept.framework.core.repository.UserDao;
import org.seept.framework.core.repository.UserRoleDao;
import org.seept.framework.core.util.DigestsUtil;
import org.seept.framework.core.util.EncodesUtil;
import org.seept.framework.core.util.QueryUtil;
import org.seept.framework.modules.persistance.ParametersFilter;
import org.seept.framework.modules.persistance.SpecificationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : lihaoquan
 */
@Component
@Transactional
public class UserService {

    public static final String HASH_ALGORITHM = "SHA-1";//哈希算法
    public static final int HASH_INTERATIONS = 1024;//哈希相互作用
    private static final int SALT_SIZE = 8;

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;


    @Autowired
    private RoleDao roleDao;


    @Autowired
    private UserRoleDao userRoleDao;

    /**
     * 创建一个用户
     * @param user
     * @return
     */
    public User createUser(User user) {
        return userDao.save(user);
    }

    /**
     * 获取所有的用户
     * @return
     */
    public List<User> getAllUsers() {
        return (List<User>) userDao.findAll();
    }


    /**
     * 根据主键获取当前用户
     * @param id
     * @return
     */
    public User findUserById(String id) {
        return userDao.findById(id);
    }


    /**
     * 注册用户
     * @param user
     * @return
     */
    public void registerUser(User user) {
        entryptPassword(user);
        user.setRegisterDate(new Date());
        userDao.save(user);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public User updateUser(User user) {
        if (StringUtils.isNotBlank(user.getPlainPassword())) {
            entryptPassword(user);
        }
        return userDao.save(user);
    }

    /**
     * 删除用户
     * @param id
     */
    public void deleteUser(String id) {
        userDao.delete(id);
    }


    public User findByLoginName(String loginName) {
        return userDao.findByLoginName(loginName);
    }


    /**
     * 获取分页处理的用户列表
     * @param filterParmatersMap
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<User> getPageUsers(Map<String,Object> filterParmatersMap,int pageNum,int pageSize) {
        return this.getPageUsers(filterParmatersMap, pageNum, pageSize,null);
    }

    /**
     *获取分页处理的用户排序列表
     *
     * 需要一个 PageRequest 和 Specification的 组合
     *
     * @param filterParmatersMap
     * @param pageNum
     * @param pageSize
     * @param sortType
     * @return
     */
    public Page<User> getPageUsers(Map<String,Object> filterParmatersMap,int pageNum,int pageSize,String sortType) {
        PageRequest pageRequest = buildPageRequest(pageNum,pageSize,sortType);
        Specification<User> specification = buildSpecification(filterParmatersMap);
        return userDao.findAll(specification,pageRequest);
    }


    /**
     * 创建分页请求
     * @param pageNum
     * @param pageSize
     * @param sortType
     * @return
     */
    public PageRequest buildPageRequest(int pageNum,int pageSize,String sortType) {
        Sort sort = null;
        if("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC,"id");
        }else if("title".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC,"loginName");
        }
        return new PageRequest(pageNum-1,pageSize,sort);
    }

    /**
     *
     * @param parmatersMap
     * @return
     */
    public Specification<User> buildSpecification(Map<String,Object> parmatersMap) {
        Specification<User> specification = null;
        try {
            specification = SpecificationManager
                      .buildSpecification(ParametersFilter.parse(parmatersMap),User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return specification;
    }


    /**
     * 通过用户编号获取角色名称列表
     * @return
     */
    public List<String> getRoleNameByUserId(String userid) {
        List<String> roleList = Lists.newArrayList();
        try {
            List<UserRole> userRoles = userRoleDao.findByUserid(userid);
            if(QueryUtil.isNotEmpty(userRoles)) {
                for(UserRole userRole : userRoles) {
                    Role role = roleDao.findOne(userRole.getRoleid());
                    if(QueryUtil.isNotEmpty(role)) {
                        roleList.add(role.getName());
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return roleList;
    }

    /**
     * 对用户密码进行散列加密
     * @param user
     */
    private void entryptPassword(User user) {
        /**
         * 生成盐
         */
        byte[] salt = DigestsUtil.generateSalt(SALT_SIZE);
        user.setSalt(EncodesUtil.encodeHex(salt));

        /**
         * 生成散列密码
         */
        byte[] password_hash = DigestsUtil.sha1(user.getPlainPassword().getBytes(),salt,HASH_INTERATIONS);
        user.setPassword(EncodesUtil.encodeHex(password_hash));
    }
}
