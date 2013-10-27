package org.seept.framework.core.service;

import com.google.common.collect.Lists;
import org.seept.framework.core.entity.User;
import org.seept.framework.core.repository.UserDao;
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

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

/**
 * @author : lihaoquan
 */
@Component
@Transactional
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

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



    public User getUser(String id) {
        return userDao.findById(id);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public User updateUser(User user) {
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

}
