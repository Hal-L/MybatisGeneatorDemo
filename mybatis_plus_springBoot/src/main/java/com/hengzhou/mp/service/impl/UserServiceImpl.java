package com.hengzhou.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hengzhou.mp.entity.User;
import com.hengzhou.mp.mapper.UserMapper;
import com.hengzhou.mp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findOne(Serializable id) {
        return userMapper.selectById(id);
    }
}
