package com.zhyu.cpmshiro.mapper;

import com.zhyu.cpmshiro.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

public interface UserMapper {
    User findByUsername(@Param("username") String username);
}
