package org.seept.framework.core.repository;

import org.seept.framework.core.entity.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author : lihaoquan
 *
 * 用户角色关联数据访问对象
 *
 */
public interface UserRoleDao extends CrudRepository<UserRole,String> {

    public List<UserRole> findByUserid(String userid);
}
