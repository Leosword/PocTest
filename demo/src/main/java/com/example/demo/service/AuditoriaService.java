package com.example.demo.service;



import java.util.List;

import com.example.demo.model.AuditoriaModel;
import com.example.demo.model.ContaModel;
import com.example.demo.model.TransacoesModel;
import com.example.demo.model.UsuarioModel;

public interface AuditoriaService {

	String obterPorAcao(String acao);

	TransacoesModel obterTrasacoesUsuario(String nome);
	

	
}
