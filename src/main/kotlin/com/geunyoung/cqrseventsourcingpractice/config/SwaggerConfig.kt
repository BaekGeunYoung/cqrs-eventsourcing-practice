package com.geunyoung.cqrseventsourcingpractice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun apiDocket(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.geunyoung.cqrseventsourcingpractice"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
    }

    fun getApiInfo(): ApiInfo {
        return ApiInfo("Event Sourcing using Axon and Spring boot",
                    "App to demonstrate Event Sourcing using Axon and Spring Boot",
                        "1.0.0",
                "Terms of Service",
                Contact("BaekGeunYoung", "github.com/BaekGeunYoung", "dvmflstm@gmail.com"),
                "",
                "",
                Collections.emptyList()
            )
    }
}