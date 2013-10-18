package org.seept.framework.core.service;

import org.seept.framework.core.entity.User;
import org.seept.framework.core.repository.UserDao;
import org.seept.framework.core.util.QueryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        if(QueryUtil.isNotEmpty(user)
                && QueryUtil.isNotEmpty(user.getId())) {
            User fetchUser = userDao.findOne(user.getId());
            if(QueryUtil.isNotEmpty(fetchUser)) {
                return fetchUser;
            }
        }
        return null;
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

}
