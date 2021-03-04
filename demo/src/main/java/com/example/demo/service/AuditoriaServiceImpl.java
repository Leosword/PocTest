package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enums.TipoDeTransacoesEnums;
import com.example.demo.model.AuditoriaModel;
import com.example.demo.model.TipoTransacaoModel;
import com.example.demo.model.TransacoesModel;
import com.example.demo.model.UsuarioModel;
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

	public List<TransacoesModel> consultarTransacoesPorData(Long idUsuario, Date data) {

		List<TransacoesModel> obterTrasacoesIdUsuario = transacoesRepository.obterTrasacoesIdUsuario(idUsuario);

		List<TransacoesModel> transacoesUsuario = new ArrayList<TransacoesModel>();

		for (TransacoesModel transacoesModel : obterTrasacoesIdUsuario) {

			if (transacoesModel.getDataTransacao().equals(data)) {

				transacoesUsuario.add(transacoesModel);
			}

		}
		return transacoesUsuario;
	}

	public List<TransacoesModel> consultarTipoTransacoesPoridUsuario(Long idUsuario, Long idTipoTransacao) {

		List<TransacoesModel> tipoTransacoes = transacoesRepository.obterTrasacoesIdUsuario(idUsuario);

		List<TransacoesModel> transacoes = new ArrayList<TransacoesModel>();

		for (TransacoesModel transacoesModel : tipoTransacoes) {

			if (transacoesModel.getTipdeDeTransacaoModel().getIdTipoTransacao().equals(idTipoTransacao)) {

				transacoes.add(transacoesModel);
			}

		}

		return transacoes;

	}
}
