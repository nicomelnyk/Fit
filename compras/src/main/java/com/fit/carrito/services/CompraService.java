package com.fit.carrito.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fit.carrito.dto.CompraDto;

@Service
public class CompraService {

	@Value("${url.compras}")
	String urlCompras;
	
	private ResponseEntity<?> get(String extensionUrl, Class<?> cls) {

		String getUrl = urlCompras + extensionUrl;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		return restTemplate.exchange(getUrl, 
				HttpMethod.GET, requestEntity, cls, cls);
	}

	public boolean comproMasDe5000EnMesCalendario(Integer dni) {
		
		LocalDate fechaActual = LocalDate.now();
	    Integer mesActual = fechaActual.getMonth().getValue();
	    Integer mesAnterior = fechaActual.getMonth().minus(1).getValue();
	    Integer anioActual = fechaActual.getYear();
	      
		@SuppressWarnings("unchecked")
		ResponseEntity<List<CompraDto>> resultado =
    				(ResponseEntity<List<CompraDto>>) get(urlCompras + "/compras/" + dni +"/fechaDesde/"
    						+ anioActual + "-" + mesAnterior +"-01/fechaHasta/" + anioActual + "-" + mesActual +"-01"
    								+ "/ordenFecha/true/ordenMonto/false", CompraDto.class);
		
		Double montoFinal = 0.0;
		for(CompraDto compra : resultado.getBody()) {
			montoFinal += compra.getMonto();
		}
		
		return montoFinal > 5000;
	}
}
