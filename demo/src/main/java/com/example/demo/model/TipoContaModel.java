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

public class TipoContaModel {

		@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	 	private Long  idTipoConta;	

		@Column(name="nome", nullable = false)
		private String nome;
		
		public TipoContaModel novoTipoConta (String nome) {
			this.nome = nome;
			return this;
		}

		

		
		
	}

