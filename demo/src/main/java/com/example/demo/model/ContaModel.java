package com.example.demo.model;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity 


public class ContaModel {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
 	private Long  idConta;	
	
	@Column (name="saldo", nullable = false)
	private BigDecimal saldo;
	
	@Column (name="extrato")
	private BigDecimal extrato;
}
