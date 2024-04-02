package com.example.ElasticitySpring.util;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;

@Configuration
public class SwaggerConfig {
//    @Bean
//    public Docket docket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .enable(true)
//                .host("localhost:8080")
//                .apiInfo(new ApiInfoBuilder()
//                        .title("Swagger Super")
//                        .description("Swagger Description details")
//                        .version("1.0").build())
//                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .paths(PathSelectors.any()).build();

        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                    .info(new Info().title("Book").version("1.0"));
        }
    }
