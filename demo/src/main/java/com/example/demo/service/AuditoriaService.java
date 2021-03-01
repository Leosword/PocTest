package com.example.demo.service;

import com.example.demo.model.TransacoesModel;

public interface AuditoriaService {

	String obterPorAcao(String acao);

	TransacoesModel obterTrasacoesUsuario(String nome);

}
