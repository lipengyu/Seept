package org.seept.framework.core.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : lihaoquan
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    Logger logger = LoggerFactory.getLogger(RegisterController.class);

    /**
     * 注册首页
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String registerPage() {
        logger.info("前往进行注册申请页面!");
        return "/account/register.jsp";
    }


    @RequestMapping(value = "/{id}")
    public String check(@PathVariable("id") String id) {
        logger.info("前往进行注册申请页面!(check):"+id);
        return "/account/register.jsp";
    }
}
