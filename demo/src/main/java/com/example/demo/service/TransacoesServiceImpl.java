package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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

	public void deposito(String nome, String beneficiario, BigDecimal valorTransacao) {

		UsuarioModel usuarioModel = usuarioRepository.obterPorNome(beneficiario);
		TransacoesModel transacoesModel = new TransacoesModel();
		TipoTransacaoModel tipoTransacaoModel = new TipoTransacaoModel();
		TipoDePagamentoModel tipoDePagamentoModel = new TipoDePagamentoModel();
		tipoDePagamentoModel.criarTipoPagamento(TipoDePagamentoEnums.AVISTA.getNome());
		tipoTransacaoModel.criarTipoTransacao(TipoDeTransacoesEnums.DEPOSITO.getNome(), tipoDePagamentoModel);
	
			TransacoesModel verificaBeneficiado = verificaBeneficiado(valorTransacao, usuarioModel, transacoesModel, tipoTransacaoModel, nome);
			BigDecimal saldoAtual = usuarioModel.getContaModel().getSaldo();
			usuarioModel.getContaModel().setSaldo(saldoAtual.add(valorTransacao));
			usuarioRepository.save(usuarioModel);
			transacoesRepository.save(verificaBeneficiado);
	}
	
	public void transferencia(String nome, String beneficiario, BigDecimal valortransacao, Integer qtdepagamento) {
		
		UsuarioModel usuarioModel = usuarioRepository.obterPorNome(nome);
		UsuarioModel beneficiado = usuarioRepository.obterPorNome(beneficiario);
		TransacoesModel transacoesModel = new TransacoesModel();
		TipoTransacaoModel tipoTransacaoModel = new TipoTransacaoModel();
		TipoDePagamentoModel tipoDePagamentoModel = new TipoDePagamentoModel();
		tipoDePagamentoModel.criarTipoPagamento(TipoDePagamentoEnums.AVISTA.getNome());
		tipoTransacaoModel.criarTipoTransacao(TipoDeTransacoesEnums.TRANSFERENCIA.getNome(), tipoDePagamentoModel);	
		
		Boolean verificaSaldo = verificaSaldo(nome, valortransacao);
		
		TransacoesModel verificaBeneficiado = verificaBeneficiado(valortransacao, usuarioModel, transacoesModel, tipoTransacaoModel, nome);
		
		if(verificaSaldo.equals(true)) {
			beneficiado.getContaModel().setSaldo(valortransacao);
			BigDecimal subtract = usuarioModel.getContaModel().getSaldo().subtract(valortransacao);
			usuarioModel.getContaModel().setSaldo(subtract);
		}
		System.out.println("Sem saldo Suficiente!");
		
		usuarioRepository.save(usuarioModel);
		usuarioRepository.save(beneficiado);
		transacoesRepository.save(verificaBeneficiado);
		
		
	}
	
	public void saque(Long idUsuario, BigDecimal valorTransacao) {
		UsuarioModel usuarioModel = usuarioRepository.obterPorID(idUsuario);
		TransacoesModel transacoesModel = new TransacoesModel();
		TipoTransacaoModel tipoTransacaoModel = new TipoTransacaoModel();
		tipoTransacaoModel.criarTipoTransacao(TipoDeTransacoesEnums.SAQUE.getNome());
		Boolean verificaSaldo = verificaSaldo(usuarioModel.getNome(), valorTransacao);

		if (verificaSaldo.equals(true)) {
			BigDecimal subtract = usuarioModel.getContaModel().getSaldo().subtract(valorTransacao);
			usuarioModel.getContaModel().setSaldo(subtract);
		}
		System.out.println("Saldo insuficiente para realizar o saque");

		TransacoesModel criaNovaTransacao = transacoesModel.criaNovaTransacao(valorTransacao, new Date(), usuarioModel.getNome(), usuarioModel,
				tipoTransacaoModel);

		usuarioRepository.save(usuarioModel);
		transacoesRepository.save(criaNovaTransacao);

	}

	
	public List<TransacoesModel> extrato(Long idUsuario, Date periodoInicial, Date periodoFinal){
		
		List<TransacoesModel> obterTrasacoesPorUsuarioPeriodo = transacoesRepository.obterTrasacoesPorUsuarioPeriodo(idUsuario, periodoInicial, periodoFinal);
		
		return obterTrasacoesPorUsuarioPeriodo; 
	
	}
	
	public Boolean verificaSaldo(String nome, BigDecimal valortransacao) {
		
		UsuarioModel usuarioModel = usuarioRepository.obterPorNome(nome);
		if(valortransacao.compareTo(usuarioModel.getContaModel().getSaldo())<=0) {
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
		
		
		return ("A Parcela"+qtdePagamento+"está paga com o valor de: "+valorTransacao);
		
		}

	
	
	public TransacoesModel verificaBeneficiado(BigDecimal valorTransacao, UsuarioModel beneficiado,
			TransacoesModel transacoesModel, TipoTransacaoModel tipoTransacaoModel, String nome) {

		if (beneficiado.getNome().equals(nome)) {
			return transacoesModel.criaNovaTransacao(valorTransacao, new Date(), beneficiado.getNome(), beneficiado,
					tipoTransacaoModel);

		}
		return transacoesModel.criaNovaTransacao(valorTransacao, new Date(), nome, beneficiado, tipoTransacaoModel);

	}
	
	
}
