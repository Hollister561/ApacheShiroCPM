package com.zhyu.cpmshiro;

import com.zhyu.cpmshiro.model.Permission;
import com.zhyu.cpmshiro.model.Role;
import com.zhyu.cpmshiro.model.User;
import com.zhyu.cpmshiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @program: ApacheShiroCPM
 * @description: 认证授权
 * @author: zhang yu
 * @create: 2019-11-25 16:01
 */

public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user = (User)principal.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList = new ArrayList<>();
        Set<Role> roleSet = user.getRoles();
        if(CollectionUtils.isEmpty(roleSet)){
            for(Role role:roleSet){
                Set<Permission> permissionSet = role.getPermissions();
                if(CollectionUtils.isEmpty(permissionSet)){
                    for(Permission permission:permissionSet){
                        permissionList.add(permission.getName());
                    }
                }

            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        return info;
    }

    //认证登录
    //从token中获取到用户名，然后获取到用户的密码
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User user = userService.findByUsername(username);
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
