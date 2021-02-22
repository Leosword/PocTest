package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TransacoesModel;
import com.example.demo.repository.TransacoesReporsitory;
import com.example.demo.repository.UsuarioRepository;


@Service
public class TransacoesServiceImpl implements TransacoesService {
	
	@Autowired 
	private TransacoesReporsitory transacoesRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<TransacoesModel> obterTrasacoesUsuario(String nome){
		return transacoesRepository.obterTrasacoesUsuario(nome);
	}
	public List<TransacoesModel> obterTrasacoesIdUsuario(Long idUsuario){
		return transacoesRepository.obterTrasacoesIdUsuario(idUsuario);
	}
	public List<TransacoesModel> obterTrasacoesbeneficiado(Long idUsuario){
		return transacoesRepository.obterTrasacoesbeneficiado(idUsuario);
	}
	public List<TransacoesModel> obterTrasacoesUsuarioData(Date dataTransacao, String nome){
		return transacoesRepository.obterTrasacoesUsuarioData(dataTransacao, nome);
	}
	public List<TransacoesModel> obterTrasacoesPorData(Date dataTransacao){
		return transacoesRepository.obterTrasacoesPorData(dataTransacao);
	}
	public List<TransacoesModel> obterTrasacoesPorPeriodo(Date dataInicial, Date dataFinal){
		return transacoesRepository.obterTrasacoesPorPeriodo(dataInicial, dataFinal);
	}
	public List<TransacoesModel> obterTrasacoesPorValorEspecifico(BigDecimal valorTransacao){
		return transacoesRepository.obterTrasacoesPorValorEspecifico(valorTransacao);
	}
	public List<TransacoesModel> obterTrasacoesPorValorMenor(BigDecimal valorTransacao){
		return transacoesRepository.obterTrasacoesPorValorMenor(valorTransacao);
	}
	public List<TransacoesModel> obterTrasacoesPorValorMaior(BigDecimal valorTransacao){
		return transacoesRepository.obterTrasacoesPorValorMaior(valorTransacao);
	}
	public List<TransacoesModel> obterTrasacoesPorDataValor(Date dataTransacao, BigDecimal valorTransacao){
		return transacoesRepository.obterTrasacoesPorDataValor(dataTransacao, valorTransacao);
	}
	public List<TransacoesModel> obterTrasacoesEntreDataValorMenor(Date datainicial, Date dataFinal, BigDecimal valorTransacao){
		return transacoesRepository.obterTrasacoesEntreDataValorMenor(datainicial, dataFinal, valorTransacao);
	}
	public List<TransacoesModel> obterTrasacoesEntreDataValorMaior(Date datainicial, Date dataFinal, BigDecimal valorTransacao){
		return transacoesRepository.obterTrasacoesEntreDataValorMenor(datainicial, dataFinal, valorTransacao);
	}
	public List<TransacoesModel> obterPorTipoTransacao(Long idTipoTransacao){
		return transacoesRepository.obterPorTipoTransacao(idTipoTransacao);
	}
	public List<TransacoesModel> obterTransacoesAvista(String qtdePagamento){
		return transacoesRepository.obterTransacoesAvista(qtdePagamento);
	}
	public List<TransacoesModel> obterTransacoesPrazo(String qtdePagamento){
		return transacoesRepository.obterTransacoesPrazo(qtdePagamento);
	}
		
	
	

}
