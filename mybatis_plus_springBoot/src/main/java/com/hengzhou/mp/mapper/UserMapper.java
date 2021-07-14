package com.hengzhou.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hengzhou.mp.entity.User;

/**
 * 使用mp定义Mapper，需要让Mapper接口继承 BaseMapper接口。
 * 我们自己写了一个接口 但是里面不需要定义任何的方法 而是要继承一个BaseMapper
 * 我们就可以使用继承过来的那些所有方法了
 * 但是 但是 但是
 * 我们继承过来的方法都只是对某个单表的增删改查
 * 如果我们想要做多表的关联查询
 * 还是需要自己在这个Mapper中去添加接口
 *
 * BaseMapper<User> 这个泛型就是指定了我们这个Mapper要操作的表是哪个
 */
public interface UserMapper extends BaseMapper<User> {
}
