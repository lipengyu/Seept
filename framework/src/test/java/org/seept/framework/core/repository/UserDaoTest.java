package org.seept.framework.core.repository;

import org.junit.Test;
import org.seept.framework.core.entity.User;
import org.seept.framework.core.util.QueryUtil;
import org.seept.framework.test.springtest.TransactionalTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

/**
 * @author : lihaoquan
 */
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class UserDaoTest extends TransactionalTestCase {

    private static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Autowired
    private UserDao userDao;

    @Test
    public void findByUserId() {
        User user =  userDao.findById("001");

        if(QueryUtil.isEmpty(user)) {
            System.out.println("找不到用户信息");
        }else {
            System.out.println("user name : "+user.getName());
        }
    }


    @Test
    public void createAndQuery() {

        User user = new User();
        user.setName("LiQuan");
        user.setLoginName("admin");
        user.setPassword("123");
        user.setRegisterDate(new Date());
        User createUser = userDao.save(user);
        if(QueryUtil.isNotEmpty(createUser)) {
            logger.info("创建用户成功");

            int count = (int) userDao.count();

            logger.info("当前用户数:"+count);

        }else {
            logger.info("创建用户失败");
        }
    }
}
