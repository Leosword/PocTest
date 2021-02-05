package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity 


public class UsuarioModel {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
 	private Long  idUsuario;
	
	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name="DataDeNascimento", nullable = false)
	private Date dtaDeNascimento;
	
	@Column(name = "RG", nullable = false)
	private Integer rg;

	@Column(name = "CPF", nullable = false)
	private Integer cpf;
	
	@Column(name = "CEP", nullable = false)
	private Integer cep;
	
	@Column(name = "Endereco", nullable = false)
	private String endereco;
	
	@Column(name = "Bairro", nullable = false)
	private String bairro;
	
	@Column (name = "cidade", nullable = false)
	private String cidade;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@Column(name = "telefone")
	private String telefone;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="conta_idconta")
	private Long usuarioIdConta;
	
		
}
