package org.seept.framework.core.repository;

import org.seept.framework.core.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author : lihaoquan
 */
public interface UserDao extends PagingAndSortingRepository<User,String>
        , JpaSpecificationExecutor<User> {


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


    @Modifying
    @Query("delete from User user where user.loginName = ?1")
    public void deleteByLoginName(String userLoginName);

    /**
     * 通过登陆名进行查询
     * @param loginName
     * @return
     */
    User findByLoginName(String loginName);
}
