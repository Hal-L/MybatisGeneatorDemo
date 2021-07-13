package com.example.demo.web;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Api(value = "类API注解_value", tags = "类API注解_tags", description = "用户接口")
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "获取所有用户信息", notes = "返回所有用户信息")
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @ApiOperation(value = "根据ID获取用户信息", notes = "返回单个用户信息")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @ApiOperation(value = "新增用户", notes = "注册")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void save(@RequestBody User user) {
        if (user.getCreateTime() == null)
            user.setCreateTime(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
        if (user.getUpdateTime() == null)
            user.setUpdateTime(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
        userMapper.insert(user);
    }

    @ApiOperation(value = "更新用户信息", notes = "更改用户信息")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public void update(@RequestBody User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @ApiOperation(value = "根据ID删除用户", notes = "删除用户信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

}