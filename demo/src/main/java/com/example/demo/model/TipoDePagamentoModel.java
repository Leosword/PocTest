package com.example.demo.model;

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


public class TipoDePagamentoModel {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTipoDePamento;
	
	@Column(name="nome",nullable = false)
	private String nome;
	
	
	@Column(name="qtdePagamento",nullable=false)
	private String qtdePagamento;
	
	
	public TipoDePagamentoModel criarTipoPagamento(String nome, String qtdepagamento) {
		this.nome = nome;
		this.qtdePagamento = qtdepagamento;
		return this;
	}
}
