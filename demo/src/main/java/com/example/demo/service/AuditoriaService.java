package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.model.PagamentoModel;
import com.example.demo.model.TransacoesModel;

public interface AuditoriaService {

	String obterPorAcao(String acao);

	TransacoesModel obterTrasacoesUsuario(String nome);

	 List<TransacoesModel> TipoDeTransacao(String nome, Date dataDaTransacao);
	 
	 PagamentoModel obterPagamentoId(Long idPag);
	 
}
