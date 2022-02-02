package com.fit.compras.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.extern.java.Log;

@OpenAPIDefinition(
        info = @Info(
                title = "Fit API compras",
                version = "0.1",
                description = "API para compras",
                contact = @Contact(name = "Nicolás Melnyk", email = "nicoomelnyk@gmail.com")
        ),
        servers = {
                @Server(description = "Testing server",
                        url = "https://testing.fit.com/compras")
        }
)

@Log
@Validated
@RestController
public class ProjectController {
    
    @Operation(summary = "Consultar el estado del proyecto")
	@GetMapping("/status")
	public ResponseEntity<?> status() {
    	log.info("Se consulta por el estado del servicio ");
		return  new ResponseEntity<>("Scheduler Service Ok", HttpStatus.OK);
	}
}