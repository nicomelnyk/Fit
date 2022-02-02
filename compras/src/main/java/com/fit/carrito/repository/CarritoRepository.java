package com.fit.carrito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fit.carrito.entity.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito,Integer>{

}
