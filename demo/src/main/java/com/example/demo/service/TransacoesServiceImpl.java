package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enums.TipoDePagamentoEnums;
import com.example.demo.enums.TipoDeTransacoesEnums;
import com.example.demo.model.PagamentoModel;
import com.example.demo.model.TipoDePagamentoModel;
import com.example.demo.model.TipoTransacaoModel;
import com.example.demo.model.TransacoesModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.PagamentoRepository;
import com.example.demo.repository.TipoDePagamentoRepository;
import com.example.demo.repository.TipoTransacaoRepository;
import com.example.demo.repository.TransacoesReporsitory;
import com.example.demo.repository.UsuarioRepository;


@Service
public class TransacoesServiceImpl implements TransacoesService {
	
	@Autowired 
	private TransacoesReporsitory transacoesRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private TipoTransacaoRepository tipoTransacaoRepository;
	
	@Autowired
	private TipoDePagamentoRepository tipoDePagamentoRepository;

	@Transactional
	public void deposito(Long idUsuario, BigDecimal valorTransacao) {

		UsuarioModel usuarioModel = usuarioRepository.obterPorID(idUsuario);
		TransacoesModel transacoesModel = new TransacoesModel();
		TipoTransacaoModel tipoTransacaoModel = tipoTransacaoRepository.obterTransacaoPorID(TipoDeTransacoesEnums.DEPOSITO.getId());
		tipoTransacaoModel.criarTipoTransacao(TipoDeTransacoesEnums.DEPOSITO.getNome());
		
		
		
		BigDecimal saldoAtual = usuarioModel.getContaModel().getSaldo();
		usuarioModel.getContaModel().setSaldo(saldoAtual.add(valorTransacao));
		
		
		
		
		TransacoesModel criaNovaTransacao = transacoesModel.criaNovaTransacao(valorTransacao, new Date(),usuarioModel.getNome(), usuarioModel, tipoTransacaoModel);
		
		usuarioRepository.save(usuarioModel);
		transacoesRepository.save(criaNovaTransacao);
	}

	@Transactional
	public void transferencia(Long idUsuario, Long idBeneficiario, BigDecimal valortransacao) {

		TransacoesModel criaNovaTransacao = null;
		UsuarioModel usuarioModel = usuarioRepository.obterPorID(idUsuario);
		UsuarioModel beneficiado = usuarioRepository.obterPorID(idBeneficiario);
		TransacoesModel transacoesModel = new TransacoesModel();
		TipoTransacaoModel tipoTransacaoModel = tipoTransacaoRepository
				.obterTransacaoPorID(TipoDeTransacoesEnums.TRANSFERENCIA.getId());
		tipoTransacaoModel.criarTipoTransacao(TipoDeTransacoesEnums.TRANSFERENCIA.getNome());

		Boolean verificaSaldo = verificaSaldo(usuarioModel.getNome(), valortransacao);

		if (verificaSaldo.equals(true)) {
			beneficiado.getContaModel().setSaldo(valortransacao);
			BigDecimal subtract = usuarioModel.getContaModel().getSaldo().subtract(valortransacao);
			usuarioModel.getContaModel().setSaldo(subtract);
			
			criaNovaTransacao = transacoesModel.criaNovaTransacao(valortransacao, new Date(), usuarioModel.getNome(),
					usuarioModel, tipoTransacaoModel);
		} else {
			System.out.println("Sem saldo Suficiente!");
		}

		usuarioRepository.save(usuarioModel);
		usuarioRepository.save(beneficiado);
		if (criaNovaTransacao != null) {
			transacoesRepository.save(criaNovaTransacao);
		} else {
			System.out.println("Transação Falhou");
		}

	}
	
	

	@Transactional
	public void saque(Long idUsuario, BigDecimal valorTransacao) {
		UsuarioModel usuarioModel = usuarioRepository.obterPorID(idUsuario);
		TransacoesModel transacoesModel = new TransacoesModel();
		TipoTransacaoModel tipoTransacaoModel = tipoTransacaoRepository.obterTransacaoPorID(TipoDeTransacoesEnums.SAQUE.getId());
		Boolean verificaSaldo = verificaSaldo(usuarioModel.getNome(), valorTransacao);

		if (verificaSaldo.equals(true)) {
			BigDecimal subtract = usuarioModel.getContaModel().getSaldo().subtract(valorTransacao);
			usuarioModel.getContaModel().setSaldo(subtract);
		} else {
			System.out.println("Saldo insuficiente para realizar o saque");
		}

		TransacoesModel criaNovaTransacao = transacoesModel.criaNovaTransacao(valorTransacao, new Date(),usuarioModel.getNome(), usuarioModel, tipoTransacaoModel);

		usuarioRepository.save(usuarioModel);
		transacoesRepository.save(criaNovaTransacao);

	}
	
	public List<TransacoesModel> extrato(Long idUsuario, Date periodoInicial, Date periodoFinal) {

		List<TransacoesModel> obterTrasacoesPorUsuarioPeriodo = transacoesRepository.obterTrasacoesPorUsuarioPeriodo(idUsuario, periodoInicial, periodoFinal);

		return obterTrasacoesPorUsuarioPeriodo;

	}
	
	public Boolean verificaSaldo(String nome, BigDecimal valortransacao) {

		UsuarioModel usuarioModel = usuarioRepository.obterPorNome(nome);
		if (valortransacao.compareTo(usuarioModel.getContaModel().getSaldo()) <= 0) {
			return true;
		}
		return false;
	}

	public String pagamento(Long idUsuario, Long idPagamento, Integer qtdePagamento, BigDecimal valorTotal) {

		UsuarioModel usuarioModel = usuarioRepository.obterPorID(idUsuario);
		PagamentoModel pagamentoId = pagamentoRepository.obterPagamentoId(idPagamento);
		TransacoesModel transacoesModel = new TransacoesModel();
		TipoTransacaoModel tipoTransacaoModel = new TipoTransacaoModel();
		PagamentoModel pagamentoModel = new PagamentoModel();
		tipoTransacaoModel.criarTipoTransacao(TipoDeTransacoesEnums.PAGAMENTO.getNome());

		BigDecimal valorTransacao = valorTotal.divide(new BigDecimal(qtdePagamento));

		Boolean verificaSaldo = verificaSaldo(usuarioModel.getNome(), valorTransacao);
		if (pagamentoId.getQtdePagamento() != 0) {
			if (verificaSaldo.equals(true)) {
				BigDecimal subtract = usuarioModel.getContaModel().getSaldo().subtract(valorTransacao);
				usuarioModel.getContaModel().setSaldo(subtract);
				pagamentoModel.setQtdePagamento(qtdePagamento -= 1);
			}
		}
		TransacoesModel criaNovaTransacao = transacoesModel.criaNovaTransacao(valorTransacao, new Date(), usuarioModel.getNome(), usuarioModel, tipoTransacaoModel);

		transacoesRepository.save(criaNovaTransacao);
		usuarioRepository.save(usuarioModel);

		return ("A Parcela" + qtdePagamento + "está paga com o valor de: " + valorTransacao);

	}
	
	
	
	public Boolean verificarDepositado(Long idUsuario, Long idBeneficiario) {
		
		if(idUsuario.equals(idBeneficiario)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	public TransacoesModel verificaBeneficiado(BigDecimal valorTransacao, UsuarioModel beneficiado,
			TransacoesModel transacoesModel, TipoTransacaoModel tipoTransacaoModel, String nome){

		if (beneficiado.getNome().equals(nome)) {
			return transacoesModel.criaNovaTransacao(valorTransacao, new Date(), beneficiado.getNome(), beneficiado,
					tipoTransacaoModel);

		}
		return transacoesModel.criaNovaTransacao(valorTransacao, new Date(), nome, beneficiado, tipoTransacaoModel);

	}

	
	
}
