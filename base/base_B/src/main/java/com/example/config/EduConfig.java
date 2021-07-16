package com.example.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan(basePackages = "com/example/mapper")
public class EduConfig {

    /**
     * 注入逻辑删除bean
     *
     * @return
     */
    // @Bean
    // public ISqlInjector sqlInjector() {
    //     return new LogicSqlInjector();  // 3.0.5 plus依赖
    // }

    /**
     * 注入分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
