package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ContaModel;

public interface ContaService {

	List<ContaModel>obterTudo();
	
	ContaModel obterContaPorNumero(String numeroConta );
	
	ContaModel obterContaPorId(Long idConta);
	
	ContaModel obterContaPorAgencia(String agencia);
	
	ContaModel obterContaPorNumeroEAgencia(String conta, String agencia);
	
	ContaModel obterContaeTipoPorNumeroEAgencia (String numeroConta, String agencia);
}