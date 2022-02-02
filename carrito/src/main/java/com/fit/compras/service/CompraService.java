package com.fit.compras.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fit.compras.entity.Compra;
import com.fit.compras.repository.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	CompraRepository compraRepository;

	public List<Compra> devolverCompras(Integer dni, Date fechaDesde, Date fechaHasta, Boolean ordenFecha, Boolean ordenMonto) {
		return compraRepository.findComprasByDniAndFechaBetween(dni, fechaDesde, fechaHasta, Sort.by(orders(ordenFecha, ordenMonto)));
	}

	private String[] orders(Boolean ordenFecha, Boolean ordenMonto) {
		List<String> ordenes = new ArrayList<String>();
		if(ordenFecha) 
			ordenes.add("fecha");
		if(ordenMonto) 
			ordenes.add("monto");
		return ordenes.toArray(new String[0]);
	}
}
