package org.seept.framework.core.service;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;
import org.seept.framework.core.entity.User;
import org.seept.framework.core.util.QueryUtil;
import org.seept.framework.test.springtest.TransactionalTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : lihaoquan
 * 用户服务测试类
 */
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class UserServiceTest extends TransactionalTestCase {

    private static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;

    @Before
    public void create() {
        logger.info("创建测试用户");
        User user = new User();
        user.setName("LiQuan");
        user.setLoginName("admin");
        user.setPassword("123");
        user.setRegisterDate(new Date());
        userService.createUser(user);
    }


    @Test
    public void testPageQuery() {

        logger.info("UserService 分页单元测试开始");

        List<User> users =  userService.getAllUsers();
        for(User user : users) {
            System.out.println("user name :"+ user.getName());
        }

        Map paramsMap = Maps.newHashMap();
        paramsMap.put("name","li");

        //Page<User> userPage = userService.getPageUsers(paramsMap,1,10);

        List<User> testUsers = userService.getTestNameUsers("LiQ");

        for(User testUser : testUsers) {
            System.out.println("--------------user name :"+ testUser.getName());
        }
    }
}
