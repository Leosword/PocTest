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
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity


public class TransacoesModel {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idTransacoes;
	
	@Column(name="valorTransacao",nullable=false)
	private  BigDecimal valorTransacao;
	
	@Column(name="dataTransacao",nullable=false)
	private Date dataTransacao;
	
	@Column(name="Beneficiario",nullable = false)
	private String beneficiario;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idUsuario")
	private UsuarioModel usuarioModel;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="idTipoTransacao")
	private TipoTransacaoModel tipdeDeTransacaoModel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "idPag")
	private PagamentoModel idpagamentoModel;
	
	public TransacoesModel criaNovaTransacao(BigDecimal valorTransacao, Date dataTransacao, String beneficiario, UsuarioModel usuarioModel, TipoTransacaoModel tipdeDeTransacaoModel) {
		this.valorTransacao = valorTransacao;
		this.dataTransacao = dataTransacao;
		this.beneficiario = beneficiario;
		this.usuarioModel = usuarioModel;
		this.tipdeDeTransacaoModel = tipdeDeTransacaoModel;
		return this;
	}


}
