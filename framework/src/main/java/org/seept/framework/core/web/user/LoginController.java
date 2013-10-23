package org.seept.framework.core.web.user;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Quan
 * @Description: 登陆操作控制器
 */
@Controller("LoginController")
@RequestMapping("/login")
public class LoginController {

    private static String LOGIN_PAGE = "/index.jsp";

    /**
     * 登陆处理函数
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String login() {
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