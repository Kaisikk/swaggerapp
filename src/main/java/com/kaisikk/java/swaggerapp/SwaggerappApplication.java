package com.kaisikk.java.swaggerapp;

import com.kaisikk.java.swaggerapp.domain.Language;
import com.kaisikk.java.swaggerapp.repo.LanguageRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerappApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(LanguageRepo languageRepo) {
        return args -> {
            languageRepo.save(new Language().setName("scala").setAuthor("odersky"));
            languageRepo.save(new Language().setName("java").setAuthor("gosling"));
            languageRepo.save(new Language().setName("elixir").setAuthor("valim"));
            languageRepo.save(new Language().setName("clojure").setAuthor("hitch"));
        };
    }

    /**
     * Настройка сваггера
     *
     * @return Docket
     */
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}
