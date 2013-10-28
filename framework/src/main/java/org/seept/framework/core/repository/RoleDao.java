package org.seept.framework.core.repository;

import org.seept.framework.core.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author: Quan
 * @Description:角色的数据访问对象
 */
public interface RoleDao extends PagingAndSortingRepository<Role,String>{

}
