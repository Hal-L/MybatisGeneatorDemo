package com.hengzhou.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hengzhou.mp.entity.User;
import com.hengzhou.mp.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
// @RunWith(SpringRunner.class)
class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 基本比较查询
     * Wrapper:
     * 1.QueryWrapper
     * LambudaQueryWrapper
     * 2.UpdateWrapper
     * LambudaUpdateWrapper
     */
    @Test
    public void testWrapper1() {
        // 1.创建查询条件构造器
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 2.设置条件
        wrapper.eq("user_name", "lisi").lt("age", 23).in("name", "李四", "王五");
        /*
        select * from tb_user where user_name = ? and age < 23 and name in (?,?)
         */
        List<User> users = userMapper.selectList(wrapper);
        log.info("users:{}", users);
    }


    @Test
    public void testWrapperOr() {
        //1.创建查询条件构建器
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //2.设置条件
        wrapper.eq("user_name", "lisi")
                .or()
                .lt("age", 23)
                .in("name", "李四", "王五");
        /*
            select * from tb_user where user_name = ? or age < ? and name in (?,?)
         */

        List<User> users = userMapper.selectList(wrapper);
        log.info("users:{}", users);
    }


    /**
     * 模糊查询
     * like:模糊查询    Parameters: %zhang%(String)
     * notlike:取得反  (user_name NOT LIKE ?) ==> Parameters: %zhang%(String)
     * likeLeft:左模糊查询   Parameters: %zhang(String)
     * likeRight:右模糊查询  Parameters: zhang%(String)
     */
    @Test
    public void testWrapperLike() {
        //1.创建查询条件构建器
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //2.设置条件
        wrapper.notLike("user_name", "zhang");
        /*
            SELECT id,user_name,password,name,age,email
             from tb_user
             where user_name like ?
             %zhang
         */
        List<User> users = userMapper.selectList(wrapper);
        log.info("users:{}", users);
    }

    /**
     * 排序查询
     * orderBy 手动指定升序还是降序
     * orderByAsc:升序
     * orderByDesc:降序
     */
    @Test
    public void testWrapperOrDerBy() {
        //1.创建查询条件构建器
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        //2.设置条件
        wrapper.eq("user_name", "lisi")
                .or()
                .lt("age", 23)
                .in("name", "李四", "王五")
                //.orderBy(true,true,"age")
                .orderByDesc("age");
        /*
            select * from tb_user where user_name = ? or age < ? and name in (?,?) order by age asc
         */

        List<User> users = userMapper.selectList(wrapper);
        log.info("users:{}", users);
    }


    /**
     * select：指定需要查询的字段
     */

    @Test
    public void testWrapperSelect() {
        //1.创建查询条件构建器
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //2.设置条件
      /*  wrapper.eq("user_name", "lisi")
                .or()
                .lt("age", 23)
                .in("name", "李四", "王五")
                //.orderBy(true,true,"age")
                .orderByDesc("age")
                .select("id", "user_name");*/
        wrapper.select("user_name");
        /*
            select id,user_name from tb_user where user_name = ? or age < ? and name in (?,?) order by age asc
         */

        List<User> users = userMapper.selectList(wrapper);
        System.out.println("users = " + users);
        log.info("users:{}", users);
    }


    /**
     * 分页条件查询
     */
    @Test
    public void testWrapperPage() {

        int current = 1;//当前页码
        int size = 2;//每页显示条数
        //1. 构建分页对象
        Page<User> page = new Page<>(current, size);
        //2. 构建条件对象
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.lt("age", 23);

        userMapper.selectPage(page, wrapper);   // Preparing: SELECT id,user_name,password,name,age,email FROM tb_user WHERE (age < ?) LIMIT ?
        List<User> records = page.getRecords();
        long total = page.getTotal();
        long pages = page.getPages();

        // log.info("userPage:{}", userPage);  // userPage:com.baomidou.mybatisplus.extension.plugins.pagination.Page@48528634
        log.info("records:{}", records);    // records:[User(id=2, userName=lisi, password=123456, name=李四, age=20, email=test2@itcast.cn), User(id=4, userName=zhaoliu, password=123456, name=赵六, age=21, email=test4@itcast.cn)]
        log.info("total:{}", total);    // 2
        log.info("pages:{}", pages);    // 1
    }

    /**
     * LambdaQueryWrapper：消除代码中的硬编码
     * User::getUserName:方法引用,解析到entity类的属性
     */
    @Test
    public void testLambdaQueryWrapper() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, "zhangsan");  // Preparing: SELECT id,user_name,password,name,age,email FROM tb_user WHERE (user_name = ?)
        userMapper.selectOne(wrapper);
    }


    /**
     * 删除条件
     */
    @Test
    public void testWrapperDelete() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "bbb"); // Preparing: DELETE FROM tb_user WHERE (user_name = ?)      Parameters: bbb(String)
        userMapper.delete(wrapper);
    }

    /**
     * 修改条件
     */
    @Test
    public void testWrapperUpdate1() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        //条件
        wrapper.eq("user_name", "lisi")
                .set("password", "22222");
        //update tb_user set password = ? where user_name = ?
        userMapper.update(null, wrapper);
    }


    @Test
    public void testWrapperUpdate2() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        //条件
        wrapper.eq("user_name", "lisi");
        //update tb_user set password = ?,age = ? where user_name = ?
        User user = new User();
        user.setPassword("3333");
        user.setAge(33);
        userMapper.update(user, wrapper);
    }

}
