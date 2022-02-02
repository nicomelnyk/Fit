package com.fit.carrito.exception;

public class ProductoInvalidoException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductoInvalidoException(String mensaje){
        super(mensaje);
    }
}