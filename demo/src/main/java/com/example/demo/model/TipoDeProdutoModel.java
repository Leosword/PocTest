package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity 


public class TipoDeProdutoModel {	

	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
 	private Long  idProduto;

	@Column(name="name", nullable = false)
	private String nome;
	


}


