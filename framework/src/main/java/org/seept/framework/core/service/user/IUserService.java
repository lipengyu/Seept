package org.seept.framework.core.service.user;

import org.seept.framework.core.entity.User;

import java.util.List;

/**
 * @author : lihaoquan
 *
 * User服务接口
 */
public interface IUserService {

    /**
     * 创建用户
     * @param user
     * @return
     */
    public User createUser(User user);


    /**
     * 获取所有用户
     * @return
     */
    public List<User> getAllUsers();


    /**
     * 获取用户
     * @param id
     * @return
     */
    public User getUser(String id);


    /**
     * 更新用户
     * @param user
     * @return
     */
    public User updateUser(User user);


    /**
     * 删除用户
     * @param id
     */
    public void deleteUser(String id);

}
