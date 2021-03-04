package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.model.AuditoriaModel;
import com.example.demo.model.PagamentoModel;
import com.example.demo.model.TransacoesModel;
import com.example.demo.model.UsuarioModel;

public interface AuditoriaService {

	
	List<TransacoesModel> consultarTransacoesPorData( Long idUsuario, Date data);
	
	List<TransacoesModel> consultarTipoTransacoesPoridUsuario(Long idUsuario,Long idTipoTransacao);
}
