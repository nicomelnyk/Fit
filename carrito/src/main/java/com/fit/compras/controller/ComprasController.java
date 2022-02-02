package com.fit.compras.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fit.compras.entity.Compra;
import com.fit.compras.service.CompraService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/")
public class ComprasController {

	@Autowired 
	CompraService compraService;
	
	@Operation(summary = "Se consulta las compras de determinado dni en determinada fecha siguiendo cierto órden")
	@GetMapping("/{dni}/fechaDesde/{fechaDesde}/fechaHasta/{fechaHasta}/ordenFecha/{ordenFecha}/ordenMonto/{ordenMonto}")
	public List<Compra> getAplicaciones(@PathVariable Integer dni, @PathVariable String fechaDesde, @PathVariable String fechaHasta,
			@PathVariable Boolean ordenFecha, @PathVariable Boolean ordenMonto) throws ClassNotFoundException, ParseException {
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		return compraService.devolverCompras(dni, formato.parse(fechaDesde), formato.parse(fechaHasta), ordenFecha, ordenMonto);
	}
}
