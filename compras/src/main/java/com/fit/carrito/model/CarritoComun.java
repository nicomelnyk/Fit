package com.fit.carrito.model;

import java.util.HashMap;

import com.fit.carrito.interfaces.Carrito;

public class CarritoComun implements Carrito {

	@Override
	public Integer descuentoPorMas3Productos() {
		return 100;
	}
	
	@Override
	public Integer descuentoEspecialVip(Double totalCompra, Integer dni) {
		return 0;
	}

}
