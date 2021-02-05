package com.example.demo.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ProdutoModel {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="Tipo_De_Conta_idTipo_De_Conta")
	private TipoContaModel tipoContaModel;
			
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="Tipo_De_Conta_conta_idconta")
	private ContaModel contaModel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="Produtos_idProtudos")
	private ProdutoModel produtoModel;
						
}
