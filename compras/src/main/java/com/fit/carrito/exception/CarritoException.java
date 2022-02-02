package com.fit.carrito.exception;

public class CarritoException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarritoException(String mensaje){
        super(mensaje);
    }
}