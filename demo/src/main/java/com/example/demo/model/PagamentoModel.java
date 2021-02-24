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
		
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="conta_idconta")
	private ContaModel contaModel;
	
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name ="idTipoDePamentoIdPagamento")
//	private TipoDePagamentoModel tipoDePagamentoModel;
}
