package com.fit.carrito.model;

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
	public Integer descuentoEspecialVip(Double totalCompra, Integer dni, Boolean comproMasDe5000) {
		if(totalCompra > 2000) {
			// Chequear si en mes calendario compro 5000 mas
			if(comproMasDe5000){ 
				return 500;
			}
		}
		return 0;
	}

}
