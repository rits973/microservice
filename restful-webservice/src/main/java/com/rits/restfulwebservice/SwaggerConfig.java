package com.rits.restfulwebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ritesh Singh
 * @version 1.0
 * @since 16/08/18
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final Contact DEFAULT_CONTACT = new Contact("Ritesh", "www.thrymr.net", "ritesh@kumar@thrymr.net");
    private static final ApiInfo DEAFAULT_API_INFO = new ApiInfo("Awesome API Documentation",
            "Awesome API Title Description", "1.0",
            "urn:tos", DEFAULT_CONTACT,
            "Apache 2.0",
            "www.thrymr.net");
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json","application/xml"));

    @Bean
    Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEAFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}
