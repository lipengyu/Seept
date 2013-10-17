package org.seept.framework.core.repository;

import org.seept.framework.core.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : lihaoquan
 */
public interface UserDao extends CrudRepository<User,String> {


    /**
     * 保存方法
     * @param user
     * @return
     */
    public User save(User user);

    /**
     *根据ID进行查询
     * @return
     */
    public User findById(String id);

}
