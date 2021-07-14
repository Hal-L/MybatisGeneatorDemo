package com.hengzhou.mp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hengzhou.mp.entity.User;
import com.hengzhou.mp.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
// @RunWith(SpringRunner.class)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据id查询
     */
    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1L);
        log.info("user:{}", user);
    }


    /**
     * 添加
     */
    @Test
    public void testInsert() {
        User user = new User();
        // 使用Mybatisplus的自动增长策略
        user.setId(9L);  // null  Auto
        user.setUserName("熊大123456");
        user.setPassword("1234");
        int count = userMapper.insert(user);
        log.info("count:{}", count);
    }

    /**
     * 删除
     */
    @Test
    public void testDeleteById() {
        //1. 根据id删除
        int count = userMapper.deleteById(7L);
        log.info("count:{}", count);
    }

    @Test
    public void testDeleteBylist() {
        //2. 根据id集合批量删除
        List ids = new ArrayList();
        ids.add(9);
        ids.add(12);
        ids.add(13);
        int i = userMapper.deleteBatchIds(ids);
        log.info("i:{}", i);

    }

    @Test
    public void testDeleteByMap() {
        //3. 根据map构造条件，删除
        // map其实就是一个删除的条件  map中的key必须要对应表中的字段名称 map中的值就是我们要删除的条件
        // 如果map中有多个key-value是一个and的关系
        Map<String, Object> map = new HashMap<>();
        //delete from tb_user where user_name = ? and age = ?
        map.put("user_name", "zhangsan");
        map.put("age", "18");
        int i = userMapper.deleteByMap(map);
        log.info("i:{}", i);
    }

    /**
     * 修改
     */
    @Test
    public void testUpdateById() {
        User user = new User();
        user.setId(2L);
        user.setPassword("1111111");
        // 根据ID去修改记录
        // 根据根据ID进行修改
        // 我们传进去的对象的属性中必须要包含ID属性
        // 我们还可以根据条件进行修改  我要修改id>10的
        int i = userMapper.updateById(user);
        log.info("i:{}", i);
    }

    /**
     * 分页查询：
     * 1. 当前页码：currentPage
     * 2. 每页显示条数：size
     * <p>
     * 注意：使用mp的分页要设置一个拦截器！！！
     */
    @Test
    public void testSelectPage() {
        // 分页可以是查询全部 分页展示
        // 条件查询 多条记录 分页展示
        // page要查询的分页参数 以及查询出来的分页结果都会保存到这个对象中
        // 传入: 要查询的页码  要查询的条数
        // 传出: 要查询的页码  要查询的条数 总的页码  总的条数  分页数据
        int current = 1;//当前页码
        int size = 2;//每页显示条数
        IPage<User> page = new Page(current, size);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        log.info("userIPage:{}", userIPage);

        List<User> records = page.getRecords();//当前页的数据
        long pages = page.getPages();//总页数 2
        long total = page.getTotal();//总记录数 4

        // 总页码 总记录数 当前页码 当前页显示的条数  分页数据
        log.info("当前页的数据,records:{}", records);
        log.info("总页数:{}", pages);
        log.info("总记录数:{}", total);

    }
}
