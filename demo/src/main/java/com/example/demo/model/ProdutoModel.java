package com.example.demo.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ProdutoModel {

	@ManyToOne(targetEntity = TipoContaModel .class)
	@JoinColumn(name ="Tipo_De_Conta_idTipo_De_Conta")
	private Long idTipoConta;
			
	@ManyToOne(targetEntity = ContaModel.class)
	@JoinColumn(name ="Tipo_De_Conta_conta_idconta")
	private Long idConta;
	
	@ManyToOne(targetEntity = TipoDeProdutoModel.class)
	@JoinColumn(name ="Produtos_idProtudos")
	private Long idProduto;
						
}
