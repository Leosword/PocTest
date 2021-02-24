package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.model.ContaModel;

public interface ContaService {

	List<ContaModel>obterTudo();
	
	ContaModel obterContaPorNumero(String numeroConta );
	
	ContaModel obterContaPorId(Long idConta);
	
	public BigDecimal obterSaldo(Long idConta);
	
	ContaModel salvarConta(ContaModel idConta);	
	
	 void deletarConta(ContaModel idConta);	
}