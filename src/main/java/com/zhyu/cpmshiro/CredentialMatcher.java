package com.zhyu.cpmshiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @program: ApacheShiroCPM
 * @description: 自定义校验规则实现类，在
 * @author: zhang yu
 * @create: 2019-11-25 16:33
 */

public class CredentialMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //获取token中的密码
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String password = new String(usernamePasswordToken.getPassword());
        //获取数据库中的密码
        String dbPassword = (String) info.getCredentials();
        //返回校验结果
        return this.equals(password,dbPassword);
    }
}
