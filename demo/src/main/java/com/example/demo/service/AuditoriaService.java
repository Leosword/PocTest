package com.example.demo.service;



import com.example.demo.model.AuditoriaModel;
import com.example.demo.model.ContaModel;
import com.example.demo.model.UsuarioModel;

public interface AuditoriaService {

	String obterPorAcao(String acao);

	AuditoriaModel obterPorNome(String nome);
}
