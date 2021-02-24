package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AuditoriaModel;
import com.example.demo.model.ContaModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.AuditoriaRepository;
import com.example.demo.repository.UsuarioRepository;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {

	@Autowired
	private AuditoriaRepository auditoriaRepository;

	public String obterPorAcao(String acao) {
		AuditoriaModel auditoriaModel = auditoriaRepository.obterPorAcao(acao);
		if (auditoriaModel.getAcao().equals(acao)) {
			return auditoriaModel.getAcao();
		} else {
			System.out.println("nao foi possivel achar a acao correspondida");
		}
		return acao;

	}

	public AuditoriaModel obterPorNome(String nome) {

		return null;
	}

}
