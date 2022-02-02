package com.fit.carrito.dto;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Validated
@Getter
@Setter
public class CrearCarritoDto {
	
	@JsonProperty("dni")
	private Integer dni;

	@JsonProperty("is_special")
	private Boolean isSpecial;
}
