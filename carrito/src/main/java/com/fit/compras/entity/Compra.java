package com.fit.compras.entity;

import java.util.Date;

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
@Table(name="compra")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Compra {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compra_id")
    private Integer compraId;

    @Column(name = "dni")
    private Integer dni;

    @Column(name = "fecha")
    private Date fecha;
    
    @Column(name = "monto")
    private Double monto;
}
