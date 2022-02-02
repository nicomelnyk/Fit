package com.fit.carrito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fit.carrito.dto.CarritoDto;
import com.fit.carrito.dto.CrearCarritoDto;
import com.fit.carrito.dto.GestionarCarritoDto;
import com.fit.carrito.model.Response;
import com.fit.carrito.services.CarritoProductoService;
import com.fit.carrito.services.CarritoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/gestionar")
public class CarritoController {
	
	@Autowired
	CarritoService carritoService;
	
	@Autowired
	CarritoProductoService carritoProductoService;
	
	@Operation(summary = "Creación de un carrito")
    @PostMapping("/create")
    public Response create(@RequestBody CrearCarritoDto carrito) {

        return new Response(carritoService.crearCarrito(carrito.getDni(), carrito.getIsSpecial()).getCarritoId().toString());
    }
    
	@Operation(summary = "Agrego un producto al carrito")
    @PostMapping("/add")
    public Response add(@RequestBody GestionarCarritoDto gestionarCarrito) {
    	
        return new Response(carritoProductoService.agregarProducto(gestionarCarrito.getCarritoId(),gestionarCarrito.getProductoId()));
    }
    
	@Operation(summary = "Quito un producto del carrito")
    @DeleteMapping("/remove")
    public Response remove(@RequestBody GestionarCarritoDto gestionarCarrito) {
    	
        return new Response(carritoProductoService.quitarProducto(gestionarCarrito.getCarritoId(),gestionarCarrito.getProductoId()));
    }
    
	@Operation(summary = "Consulto la cantidad de productos que tiene un carrito")
    @GetMapping("/{idCarrito}")
    public Response status(@PathVariable Integer idCarrito) {

        return new Response(carritoProductoService.consultarProductos(idCarrito).toString());
    }
    
	@Operation(summary = "Finalizo la compra del carrito")
    @PostMapping("/finalizar")
    public Response create(@RequestBody CarritoDto carrito) {

        return new Response(carritoService.finalizarCompra(carrito.getCarrito_id()));
    }

}
