package com.example.demo.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        //增加请求头信息
        List<Parameter> pars = new ArrayList<Parameter>();
        ticketPar.name("token")
                .description("请求令牌")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                //.groupName("基础模块")
                // TODO: 无效代码  // 要扫描的API(Controler)基础包 //加了ApiOperation注解的方法，生成接口文档  //带注解ApiOperation的controller都会扫描出来
                // .apis(RequestHandlerSelectors.basePackage("com.exmple.demo.web"))
                //可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any())
                //指定扫描路径下的的controller
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build();
    }

    // @Bean
    // public Docket swaggerSpringMvcPlugin() {
    //     return new Docket(DocumentationType.SWAGGER_2).select()
    //             .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
    // }

    private ApiInfo buildApiInfo() {
        Contact contact = new Contact("swagger_", "", "");
        return new ApiInfoBuilder()
                //设置文档的标题
                .title("API-文档")
                //设置文档的描述
                .description("api")
                //作者信息
                .contact(contact)
                //设置文档的License信息
                .termsOfServiceUrl("http://blog.csdn.net/u011781521?viewmode=contents")
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                //设置文档的版本信息
                .version("1.0.1").build();
    }

}
