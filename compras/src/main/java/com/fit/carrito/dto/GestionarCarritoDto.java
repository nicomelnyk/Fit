package com.fit.carrito.dto;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Validated
@Getter
@Setter
public class GestionarCarritoDto {

	@JsonProperty("carrito_id")
	private Integer carritoId;

	@JsonProperty("producto_id")
	private Integer productoId;
}
