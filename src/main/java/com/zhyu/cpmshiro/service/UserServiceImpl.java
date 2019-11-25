package com.zhyu.cpmshiro.service;

import com.zhyu.cpmshiro.mapper.UserMapper;
import com.zhyu.cpmshiro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @program: ApacheShiroCPM
 * @description: UserService的实现类
 * @author: zhang yu
 * @create: 2019-11-25 14:58
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
