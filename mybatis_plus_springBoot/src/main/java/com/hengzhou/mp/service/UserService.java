package com.hengzhou.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hengzhou.mp.entity.User;

import java.io.Serializable;
/**
 * Service封装
 * 1. 定义接口继承IService
 * 2. 定义实现类继承ServiceImpl<Mapper，Entity> 实现定义的接口
 *
 */
public interface UserService extends IService<User> {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public User findOne(Serializable id);
}
