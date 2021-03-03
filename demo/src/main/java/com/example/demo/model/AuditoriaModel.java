package com.example.demo.model;

import java.math.BigDecimal;
import java.sql.Date;

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

public class AuditoriaModel {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAuditoria;

	@Column(name = "acao", nullable = false)
	private String acao;

	@Column(name = "data", nullable = false)
	private Date data;

	@Column(name = "hora", nullable = false)
	private Date hora;

	@Column(name = "valor", nullable = false)
	private BigDecimal valor;

//	@Column(name = "valorAnterior", nullable = false)
//	private BigDecimal valorAnterior;

	@Column(name = "novovalor", nullable = false)
	private BigDecimal novoValor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Usuario_idUsuario")
	private UsuarioModel usuarioModel;
	


	
	
}
