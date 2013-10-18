package org.seept.framework.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: Quan
 * @Description: 登陆操作控制器
 */
@Controller("LoginController")
@RequestMapping("/login")
public class LoginController {

    /**
     * 登陆处理函数
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String login() {
        return null;
    }


    /**
     * 登陆失效
     * @return
     */
    public String disLogin() {
        return null;
    }
}
