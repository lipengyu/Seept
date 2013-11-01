package org.seept.framework.core.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.seept.framework.core.entity.User;
import org.seept.framework.test.security.ShiroTestUtils;
import org.seept.framework.test.springtest.TransactionalTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

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
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ShiroTestUtils.mockSubject(new SeeptRealm.SecurityUser("ooooo1", "foo", "Foo"));
    }

    @Test
    public void create() {
        logger.info("创建测试用户");
        User user = new User();
        user.setName("小明");
        user.setLoginName("ming");
        user.setPlainPassword("admin");
        user.setRegisterDate(new Date());
        user =  userService.registerUser(user);
        //691b14d79bf0fa2215f155235df5e670b64394cc
        System.out.println("创建用户完成 : "+user.getLoginName()+"---"+user.getPassword()+"   " +
                "         "+user.getSalt());
    }


   /* @Test
    public void testPageQuery() {

        logger.info("UserService 分页单元测试开始");

        List<User> users =  userService.getAllUsers();
        for(User user : users) {
            System.out.println("user name :"+ user.getName());
        }

        Map paramsMap = Maps.newHashMap();
        paramsMap.put("LIKE_name","Li");

        Page<User> userPage = userService.getPageUsers(paramsMap,1,1);

        System.out.println(userPage.getTotalPages());


        List<String> roleList = userService.getRoleNameByUserId("U002");

        logger.info("roleList : "+roleList.size());

    }*/
}
