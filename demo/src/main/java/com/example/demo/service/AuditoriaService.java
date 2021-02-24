package com.example.demo.service;


import java.util.Date;

import com.example.demo.model.AuditoriaModel;

public interface AuditoriaService {

	AuditoriaModel obterPorAcao(String acao);	
	
	AuditoriaModel obterPorAcaoCpf(String acao, String cpf);
	
	AuditoriaModel obterPorData(Date data);
	
	AuditoriaModel obterPorNomeData(String nome, Date data);
	

}
