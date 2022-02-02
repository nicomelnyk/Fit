package com.fit.carrito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit.carrito.entity.CarritoProducto;
import com.fit.carrito.exception.ProductoInvalidoException;
import com.fit.carrito.repository.CarritoProductoRepository;
import com.fit.carrito.repository.CarritoRepository;

@Service
public class CarritoProductoService {
	
	@Autowired
	CarritoProductoRepository carritoProductoRepository;

	@Autowired
	CarritoRepository carritoRepository;
	
	public String agregarProducto(Integer carritoId, Integer productoId) {
		List<CarritoProducto> carritoProducto = carritoProductoRepository.findCarritoProductoByCarritoIdAndProductoId(carritoId, productoId);
		fallarSiElCarritoYaFinalizo(carritoProducto);
		return carritoProductoRepository.save(construirCarritoProducto(carritoId, productoId)).getCarritoProductoId().toString();
	}
	
	public String quitarProducto(Integer carritoId, Integer productoId) {
		List<CarritoProducto> carritoProducto = carritoProductoRepository.findCarritoProductoByCarritoIdAndProductoId(carritoId, productoId);
		fallarSiElCarritoYaFinalizo(carritoProducto);
		if(carritoProducto.size() > 0) {
			carritoProductoRepository.deleteById(carritoProducto.get(0).getCarritoProductoId());
			return "OK";
		}
		throw new ProductoInvalidoException("Producto no existente");
	}
	
	private void fallarSiElCarritoYaFinalizo(List<CarritoProducto> carritoProducto) {
		if(carritoRepository.getById(carritoProducto.get(0).getCarritoId()).getValorFinal() == null) 
			throw new ProductoInvalidoException("Compra finalizada");
		
	}

	private CarritoProducto construirCarritoProducto(Integer carritoId, Integer productoId) {
		return CarritoProducto.builder().carritoId(carritoId).productoId(productoId).build();
	}


	public Integer consultarProductos(Integer idCarrito) {
		return carritoProductoRepository.findCarritoProductoByCarritoId(idCarrito).size();
	}

}
