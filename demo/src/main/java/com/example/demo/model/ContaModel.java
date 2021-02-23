package com.example.demo.model;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity 


public class ContaModel {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
 	private Long  idConta;	
	
	@Column (name="numero_da_conta", nullable = false)
	private String numeroConta;
	
	@Column (name="gencia", nullable = false)
	private String agencia;
	
	@Column (name="saldo", nullable = false)
	private BigDecimal saldo;
	
	@Column (name="extrato")
	private BigDecimal extrato;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="Tipo_De_Conta_idTipo_De_Conta")
	private TipoContaModel tipoContaModel;
	
	
}
