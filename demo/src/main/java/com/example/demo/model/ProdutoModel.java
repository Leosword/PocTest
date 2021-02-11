package com.example.demo.model;


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
public class ProdutoModel {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="Tipo_De_Conta_idTipo_De_Conta")
	private TipoContaModel tipoContaModel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="Tipo_De_Produto_idProduto")
	private TipoDeProdutoModel tipoDeProdutoModel;
							
}
