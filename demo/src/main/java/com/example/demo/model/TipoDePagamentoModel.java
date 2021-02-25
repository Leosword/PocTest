package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name = "idPag")
	private PagamentoModel idPagamentoModel;
	
	public TipoDePagamentoModel criarTipoPagamento(String nome, PagamentoModel idPag) {
		PagamentoModel pagamentoModel = new PagamentoModel();
		if(pagamentoModel.getQtdePagamento() > 1) {
			this.idTipoDePamento = TipoDePagamentoEnums.PARCELADO.getId();
			this.nome = TipoDePagamentoEnums.PARCELADO.getNome();
			this.idPagamentoModel = idPag;
			}
		this.idTipoDePamento = TipoDePagamentoEnums.AVISTA.getId();
		this.nome = TipoDePagamentoEnums.AVISTA.getNome();
		this.idPagamentoModel = idPag;
		
		return this;
	}
	
	public TipoDePagamentoModel criarTipoPagamento(String nome) {
		PagamentoModel pagamentoModel = new PagamentoModel();
		if(pagamentoModel.getQtdePagamento() > 1) {
			this.idTipoDePamento = TipoDePagamentoEnums.PARCELADO.getId();
			this.nome = TipoDePagamentoEnums.PARCELADO.getNome();
			}
		this.idTipoDePamento = TipoDePagamentoEnums.AVISTA.getId();
		this.nome = TipoDePagamentoEnums.AVISTA.getNome();
		
		return this;
	}
}
