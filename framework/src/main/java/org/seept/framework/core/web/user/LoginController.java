package org.seept.framework.core.web.user;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Quan
 * @Description: 登陆操作控制器
 *
 * 这里的登录控制器只实现登录跳转,真正的业务是交给Shiro处理的.
 * 首先请求会被ShiroFilter拦截,鉴权操作会到SeeptRealm处理.
 *
 */
@Controller("LoginController")
@RequestMapping("/login")
public class LoginController {

    private static String LOGIN_PAGE = "/account/login.jsp";

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 登陆处理函数
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String login() {
        logger.info("用户登录");
        return LOGIN_PAGE;
    }


    /**
     * 登陆失效
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String disLogin(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName,
                           Model model) {
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
        return LOGIN_PAGE;
    }
}
