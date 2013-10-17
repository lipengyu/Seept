package org.seept.framework.core.service.user;

import org.seept.framework.core.entity.User;
import org.seept.framework.core.repository.UserDao;
import org.seept.framework.core.util.QueryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Quan
 * @Description: User服务接口实现类
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements IUserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    /**
     * 创建一个用户
     * @param user
     * @return
     */
    @Override
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

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public User getUser(String id) {
        return userDao.findById(id);
    }

    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }

    /**
     * 删除用户
     * @param id
     */
    @Override
    public void deleteUser(String id) {
        userDao.delete(id);
    }
}
