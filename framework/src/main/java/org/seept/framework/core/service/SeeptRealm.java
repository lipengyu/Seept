package org.seept.framework.core.service;

import com.google.common.base.Objects;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.seept.framework.core.entity.User;
import org.seept.framework.core.util.EncodesUtil;
import org.seept.framework.core.util.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

/**
 * @author : lihaoquan
 */
public class SeeptRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initHashCredentials() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(userService.HASH_ALGORITHM);
        matcher.setHashIterations(userService.HASH_INTERATIONS);

        setCredentialsMatcher(matcher);
    }

    /**
     *授权操作
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SecurityUser securityUser =  (SecurityUser)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<String> roles = userService.getRoleNameByUserId(securityUser.getId());
        info.addRoles(roles);
        return info;
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
            byte[] salt = EncodesUtil.decodeHex(user.getSalt());

            simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                    new SecurityUser(user.getId(),user.getLoginName(),user.getName()),
                    user.getPassword(),
                    ByteSource.Util.bytes(salt), //密码算法加盐处理
                    getName()
            );
        }
        return simpleAuthenticationInfo;
    }

    /**
     * 安全用户信息对象,在这类定义为静态内部类(静态嵌套类)
     * 使用静态内部类，多个外部类的对象可以共享同一个内部类的对象。
     */
    public static class SecurityUser implements Serializable {
        private static final long serialVersionUID = -1373760761780840081L;
        public String id;
        public String loginName;
        public String name;

        public SecurityUser(String id, String loginName, String name) {
            this.id = id;
            this.loginName = loginName;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        /**
         * 在前台可通过 <shiro:principal property="loginName" /> 获得属性值
         * @return
         */
        public String getLoginName() {
            return loginName;
        }

        /**
         * 在前台可通过 <shiro:principal property="name" /> 获得属性值
         * @return
         */
        public String getName() {
            return name;
        }

        /**
         * 本函数输出将作为默认的<shiro:principal/>输出.
         */
        @Override
        public String toString() {
            return loginName;
        }

        /**
         * 重载hashCode,只计算loginName;
         */
        @Override
        public int hashCode() {
            return Objects.hashCode(loginName);
        }

        /**
         * 重载equals,只计算loginName;
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            SecurityUser other = (SecurityUser) obj;
            if (loginName == null) {
                if (other.loginName != null) {
                    return false;
                }
            } else if (!loginName.equals(other.loginName)) {
                return false;
            }
            return true;
        }
    }

}
