package org.employeems.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Slf4j
public class WebMvcConfiguration {
    @Bean
    public Docket docketUser() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("员工管理系统接口文档")
                .version("1.0")
                .description("员工管理系统接口文档")
                .build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("员工相关接口")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.employeems.controller.employee.EmployeeController"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

//    @Bean
//    public Docket docketAdmin() {
//        ApiInfo apiInfo = new ApiInfoBuilder()
//                .title("员工管理系统接口文档")
//                .version("1.0")
//                .description("员工管理系统接口文档")
//                .build();
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .groupName("管理端接口")
//                .apiInfo(apiInfo)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.token.controller.admin"))
//                .paths(PathSelectors.any())
//                .build();
//        return docket;
//    }
//
//    @Bean
//    public Docket docketCommon() {
//        ApiInfo apiInfo = new ApiInfoBuilder()
//                .title("token店铺项目接口文档")
//                .version("1.0")
//                .description("token店铺项目接口文档")
//                .build();
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .groupName("通用端接口")
//                .apiInfo(apiInfo)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.token.controller.common"))
//                .paths(PathSelectors.any())
//                .build();
//        return docket;
//    }

    /**
     * 设置静态资源映射
     *
     * @param registry
     */
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("swagger接口网站加载...");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
