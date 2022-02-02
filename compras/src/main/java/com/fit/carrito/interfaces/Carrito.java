package com.fit.carrito.interfaces;

import java.util.HashMap;

public interface Carrito {
	
	public default Double descuentoFinal(Double valorFinalSinDto, HashMap<Integer, Integer> map, Integer dni, Boolean comproMasDe5000) {
		valorFinalSinDto -= descuentoEspecialVip(valorFinalSinDto, dni, comproMasDe5000);
		valorFinalSinDto -= descuentoPorMas3Productos();
		return valorFinalSinDto < 0 ? 0 : valorFinalSinDto;
	}

	public Integer descuentoPorMas3Productos();
	
	public Integer descuentoEspecialVip(Double totalCompra, Integer dni, Boolean comproMasDe5000);
}
