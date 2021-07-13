package com.example.demo.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                // TODO: 2021/7/12 错误代码  // 要扫描的API(Controler)基础包
                // .apis(RequestHandlerSelectors.basePackage("com.exmple.demo.web"))
                .paths(PathSelectors.any())

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
                .title("API-文档")
                .description("api")
                .contact(contact)
                .version("1.0.1").build();
    }

}
