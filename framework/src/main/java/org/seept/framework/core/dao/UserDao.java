package org.seept.framework.core.dao;

import org.seept.framework.core.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author : lihaoquan
 * 用户数据传输处理接口
 */
public interface UserDao extends PagingAndSortingRepository<User,String> {

}
