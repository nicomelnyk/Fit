package com.fit.carrito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fit.carrito.entity.CarritoProducto;

@Repository
public interface CarritoProductoRepository extends JpaRepository<CarritoProducto,Integer>{

	List<CarritoProducto> findCarritoProductoByCarritoId(Integer idCarrito);

	List<CarritoProducto> findCarritoProductoByCarritoIdAndProductoId(Integer carritoId, Integer productoId);

}
