package com.programacion.reactiva.Sofkasemana2;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
//@EnableWebFlux
@OpenAPIDefinition(info = @Info(
		title = "Segunda Semana Spring webflux Implementacion de Crud Simple y Swagger ",
		version = "1.0.0",
		description = "Practica para afianzar conocimientos de ractividad y funcional"
))
public class SofkaSemana2Application {

	public static void main(String[] args) {
		SpringApplication.run(SofkaSemana2Application.class, args);
	}

}
