package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity


public class TipoTransacao {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long iddTipoTransacao;
	
	
	@Column(name="Nome",nullable=false)
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idTipo_De_Pagamento")
	private TipoDePagamento idTipoDePagamento;
}
