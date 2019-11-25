package com.zhyu.cpmshiro.service;

import com.zhyu.cpmshiro.model.User;

public interface UserService {
    User findByUsername(String username);
}
