package com.hengzhou.mp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 实体类的属性名和数据库的字段名 自动映射：
 *  1. 名称一样(区分大小写 首字母大写是可以的 但是没人这么干)
 *  2. 数据库字段使用_分割，实体类属性名使用驼峰名称
 *
 *  实体类的书写规范
 *  必须要实现Serializable类接口
 *  所有的成员变量必须是私有的
 *  然后给这些私有的成员变量提供公有的setter getter方法
 *  如果成员变量是基本数据类型 我们使用他们对应的包装类
 */

// tb_User
// tb_us_er
// @TableName("tb_user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    //设置id生成策略:AUTO 数据库自增
    // TableId注解是用来标记这个成员变量是一个主键
    // IdType.AUTO 代表使用数据库的主键自增长策略
    // @TableId(type = IdType.AUTO)
    private Long id;
    // TableField注解是用来标记属性名称和表中的字段名称的对应关系
    // 如果属性名和字段名一致可以不写  如果属性名中的驼峰对应字段中的_也可以不写
    // @TableField("user_name")
    // use_rname
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private String email;

    // 插入的时候不希望该值存入数据库
    // 查询的时候不希望去封装该值
    /*@TableField(exist = false)
    private String info;*/
}
