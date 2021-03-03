package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AuditoriaModel;
import com.example.demo.repository.AuditoriaRepository;
import com.example.demo.repository.TransacoesReporsitory;
import com.example.demo.repository.UsuarioRepository;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {

	@Autowired
	private AuditoriaRepository auditoriaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private TransacoesReporsitory transacoesRepository;
	
	@Autowired
	private TransacoesService transacoesService;

	
	public List<AuditoriaModel>consultarTudo(String acao, Long idUsuario,Date data,Date hora) {
	
		List<AuditoriaModel> obterTodos = new ArrayList<>();
		List<AuditoriaModel> obterAcao = auditoriaRepository.obterPorAcao(acao);
		obterTodos.addAll(obterAcao);
		List<AuditoriaModel>obterAcaoDataHora = auditoriaRepository.obterPorAcaoDataHora(acao, data, hora);
		
		return obterTodos;
	}


	
	
	
	
				
	
	
	
	
	
}
