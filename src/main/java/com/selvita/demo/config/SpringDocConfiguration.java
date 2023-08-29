package com.selvita.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean(name = "com.ssosnik.apprating.configuration.SpringDocConfiguration.apiInfo")
    OpenAPI apiInfo() {
        Contact contact = new Contact();
        contact.setName("Sebastian Sosnik");
        contact.setUrl("https://github.com/ssosnik/");
        contact.setEmail("s.sosnik@gmail.com");

        return new OpenAPI().info(new Info().title("Car OpenAPI definition").description(
                        "Offers CRUD end-points for car management")
                .version("0.0.1"));
    }
}