package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AuditoriaModel;
import com.example.demo.model.TransacoesModel;
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
	
	public String obterPorAcao(String acao) {
		AuditoriaModel auditoriaModel = auditoriaRepository.obterPorAcao(acao);
		if (auditoriaModel.getAcao().equals(acao)) {
			return auditoriaModel.getAcao();
		} else {
			System.out.println("nao foi possivel achar a acao correspondida");
		}
		return acao;

	}
	public TransacoesModel obterTrasacoesUsuario(String nome) {
		TransacoesModel transacoesModel = new TransacoesModel();
		if(transacoesRepository.obterTrasacoesUsuario(nome).equals(nome)) {
			return transacoesModel;
		}
		return transacoesModel;
	}
		

		public List<TransacoesModel> TipoDeTransacao(String nome, Date data){
			
			//TransacoesModel
			
			return null;
		}
		
		
		

	
		
	}
		
		

		
		
		
	
			
	

