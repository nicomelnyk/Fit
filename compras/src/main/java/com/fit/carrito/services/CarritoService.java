package com.fit.carrito.services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit.carrito.entity.Carrito;
import com.fit.carrito.entity.CarritoProducto;
import com.fit.carrito.entity.Producto;
import com.fit.carrito.exception.CarritoException;
import com.fit.carrito.model.CarritoComun;
import com.fit.carrito.model.CarritoEspecial;
import com.fit.carrito.repository.CarritoProductoRepository;
import com.fit.carrito.repository.CarritoRepository;
import com.fit.carrito.repository.ProductoRepository;

@Service
public class CarritoService {

	@Autowired
	CarritoRepository carritoRepository;
	
	@Autowired
	CarritoProductoRepository carritoProductoRepository;
	
	@Autowired
	ProductoRepository productoRepository;

	public Carrito crearCarrito(Integer dni, Boolean isSpecial) {
		return carritoRepository.save(Carrito.builder().dni(dni).isSpecial(isSpecial).build());
	}

	@SuppressWarnings("null")
	public String finalizarCompra(Integer idCarrito) {
		Optional<Carrito> carrito = carritoRepository.findById(idCarrito);
		if(carrito.isPresent()) {
			Carrito carritoPresente = carrito.get();
			List<CarritoProducto> carritoProductos = carritoProductoRepository.findCarritoProductoByCarritoId(idCarrito);
			
			// Acá se podría agregar una query compleja, será más rápido (joineando tablas)
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			Double valorFinalSinDto = 0.0;
			Double valorFinal = 0.0;
			
			// Itero para obtener los productos que compró, el valor final de la compra sin dto. y contabilizo la cantidad de c/u
			for(CarritoProducto carritoProducto : carritoProductos) {
				Integer id = carritoProducto.getProductoId();
				Producto producto = productoRepository.getById(id);
				valorFinalSinDto += producto.getValor();
				if(map.get(id) != null) {
					map.put(id, map.get(producto.getProductoId()) + 1);
				} else {
					map.put(id, 1);
				}
			}
			
			// Primero aplico el dto. 4x3 que es común para todos
			for (Entry<Integer, Integer> entry : map.entrySet()) {
				if(entry.getValue() > 4) {
					valorFinalSinDto -= productoRepository.getById(entry.getKey()).getValor();
				}
			}
			
			Integer dni = carritoPresente.getDni();
			
			// Calculo el precio final de la compra
			if(carritoPresente.getIsSpecial()) {
				CarritoComun comun = new CarritoComun();
				valorFinal = comun.descuentoFinal(valorFinalSinDto, map, dni);
			} else {
				CarritoEspecial especial = new CarritoEspecial();
				valorFinal = especial.descuentoFinal(valorFinalSinDto, map, dni);
			}
			carritoPresente.setValorFinal(valorFinal);
			carritoRepository.save(carritoPresente);
			return "Compra OK";
		}
		throw new CarritoException("CarritoNoExsitente");
	}
}
