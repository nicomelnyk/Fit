package com.fit.carrito.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="carrito_producto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarritoProducto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrito_producto_id")
    private Integer carritoProductoId;
	
    @Column(name = "carrito_id")
    private Integer carritoId;
    
    @Column(name = "producto_id")
    private Integer productoId;
}
