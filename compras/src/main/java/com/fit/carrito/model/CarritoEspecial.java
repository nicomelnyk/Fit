package com.fit.carrito.model;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.fit.carrito.interfaces.Carrito;
import com.fit.carrito.services.CompraService;

public class CarritoEspecial implements Carrito {
	
	@Autowired
	CompraService compraService;

	@Override
	public Integer descuentoPorMas3Productos() {
		return 100;
	}
	
	@Override
	public Integer descuentoEspecialVip(Double totalCompra, Integer dni) {
		if(totalCompra > 2000) {
			// Chequear si en mes calendario compro 5000 mas
			if(compraService.comproMasDe5000EnMesCalendario(dni)){ 
				return 500;
			}
		}
		return 0;
	}

}
