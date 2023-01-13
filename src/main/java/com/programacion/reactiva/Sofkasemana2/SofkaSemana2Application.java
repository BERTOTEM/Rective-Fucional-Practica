package com.programacion.reactiva.Sofkasemana2;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Spring webflux crud example",
		version = "1.0",
		description = "sample documents"
))
public class SofkaSemana2Application {

	public static void main(String[] args) {
		SpringApplication.run(SofkaSemana2Application.class, args);
	}

}
