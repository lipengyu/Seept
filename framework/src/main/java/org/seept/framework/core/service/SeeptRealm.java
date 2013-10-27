package org.seept.framework.core.service;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.seept.framework.core.entity.User;
import org.seept.framework.core.util.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : lihaoquan
 */
public class SeeptRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     *授权操作
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    /**
     * 认真操作
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {

        SimpleAuthenticationInfo simpleAuthenticationInfo = null;
        /**
         * 获取授权令牌
         */
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.findByLoginName(token.getUsername());
        if(QueryUtil.isNotEmpty(user)) {
             System.out.println("用户校验成功!");
        }else {
            System.out.println("用户不存在");
        }
        return simpleAuthenticationInfo;
    }


}
