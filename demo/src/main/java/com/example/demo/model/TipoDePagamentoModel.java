package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.enums.TipoDePagamentoEnums;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity


public class TipoDePagamentoModel {
	@Id@Column(name="idTipo_De_Pagamento", nullable = false)
	private Long idTipoDePamento;
	
	@Column(name="nome",nullable = false)
	private String nome;
	
	
	@Column(name="qtdePagamento",nullable=false)
	private Integer qtdePagamento;
	
	
	public TipoDePagamentoModel criarTipoPagamento(String nome, Integer qtdepagamento) {
		this.qtdePagamento = qtdepagamento;
		if(qtdePagamento > 1) {
			this.idTipoDePamento = TipoDePagamentoEnums.PARCELADO.getId();
			this.nome = TipoDePagamentoEnums.PARCELADO.getNome();
			}
		this.idTipoDePamento = TipoDePagamentoEnums.AVISTA.getId();
		this.nome = TipoDePagamentoEnums.AVISTA.getNome();
		
		
		return this;
	}
}
