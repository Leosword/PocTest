package com.example.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AuditoriaModel;
import com.example.demo.model.PagamentoModel;
import com.example.demo.model.ProdutoModel;
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
		

		public List<TransacoesModel> TipoDeTransacao(String nome, Date dataDaTransacao){
			List<TransacoesModel> TipoTransacao = new ArrayList<>();
			UsuarioModel usuarioModel = new UsuarioModel();
			TransacoesModel transacoesModel = new TransacoesModel();
			TipoTransacao.add(transacoesModel);
		if(usuarioModel.getNome().equals(nome) && transacoesModel.getDataTransacao().equals(dataDaTransacao) ) {
			
			return TipoTransacao;
		}
		
	return TipoTransacao;
		
		}
		public PagamentoModel obterPagamentoId(Long idPag) {
			
			PagamentoModel pagamentoModel = new PagamentoModel();
			if(idPag.equals(pagamentoModel.getIdPag())) {
				return pagamentoModel;
			}
			return pagamentoModel;
			
			
		}
		public ProdutoModel obterTipoProduto(Long idProduto) {
			
			ProdutoModel produtoModel = new ProdutoModel();
			if(idProduto.equals(produtoModel.getIdProduto())) {
				
				return produtoModel;
			}
			
			return null;
		}
	
		
	}
		
		

		
		
		
	
			
	

