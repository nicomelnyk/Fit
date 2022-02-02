package com.fit.carrito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fit.carrito.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer>{

}
