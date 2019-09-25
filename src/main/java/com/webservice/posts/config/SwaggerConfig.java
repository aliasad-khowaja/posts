package com.webservice.posts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact MY_CONTACT = new Contact("Ali Asad", "www.aliasad.com", "a2.khowaja@gmail.com");
    public static final ApiInfo MY_API_INFO = new ApiInfo("Posts Api Documentation", "Post Api Documentation",
            "1.0", "urn:tos", MY_CONTACT, "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(MY_API_INFO);
    }

}
