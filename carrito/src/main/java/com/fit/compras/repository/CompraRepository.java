package com.fit.compras.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fit.compras.entity.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Integer>{

	List<Compra> findComprasByDniAndFechaBetween(Integer dni, Date fechaDesde, Date fechaHasta, Sort by);
}
