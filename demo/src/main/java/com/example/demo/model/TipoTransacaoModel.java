package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.enums.TipoDeTransacoesEnums;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity


public class TipoTransacaoModel {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTipoTransacao;
	
	
	@Column(name="Nome",nullable=false)
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idTipo_De_Pagamento")
	private TipoDePagamentoModel idTipoDePagamento;
	
	public TipoTransacaoModel criarTipoTransacao(String nome, TipoDePagamentoModel idTipoDePagamento) {
		this.nome = nome;
		this.idTipoDePagamento = idTipoDePagamento;
		return this;
	}
	public TipoTransacaoModel criarTipoTransacao(String nome) {
		this.nome = nome;
		return this;
	}
	
}
