package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity 
public class PagamentoModel {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
 	private Long  idPag;
	
	@Column(name = "valorTotal", nullable = false)
	private BigDecimal valorTotal;

	@Column(name = "estabelecimento", nullable = false)
	private String estabelecimento;

	@Column(name = "dataPag", nullable = false)
	private Date dataPag;
	
	@Column(name="qtdePagamento",nullable=false)
	private Integer qtdePagamento;
	
	
	
	public PagamentoModel criaNovoPagamento(Long idPag, BigDecimal valorTotal, String estabelecimento, Date dataPag, Integer qtdePagamento) {
		this.idPag = idPag;
		this.valorTotal = valorTotal;
		this.estabelecimento = estabelecimento;
		this.dataPag = dataPag;	
		this.qtdePagamento = qtdePagamento;
		return this;
	}
	
}
