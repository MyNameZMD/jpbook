package com.jpbook.shiro;

import com.jpbook.entity.Users;
import org.apache.catalina.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

public class UserRealm extends AuthorizingRealm {

    @Override//执行授权逻辑
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo();

        Subject subject = SecurityUtils.getSubject();

        //Touruser touruse=(Touruser) subject.getPrincipal();

        return null;
    }

    @Override//执行认证逻辑
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //编写shiro判断逻辑，判断用户和密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        if(null == token.getUsername()){
            //用户名不存在
            return null; //shiro底层会抛出UnKnowAccountException
        }

        return new SimpleAuthenticationInfo(token.getUsername(),token.getPassword(),"");
    }
}
