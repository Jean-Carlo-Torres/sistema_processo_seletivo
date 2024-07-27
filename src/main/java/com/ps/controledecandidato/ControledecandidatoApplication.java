package com.ps.controledecandidato;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Swagger OpenApi",
                version = "1",
                description = "API Web para controle de candidatos em processo seletivo")
)
public class ControledecandidatoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControledecandidatoApplication.class, args);
    }

}
