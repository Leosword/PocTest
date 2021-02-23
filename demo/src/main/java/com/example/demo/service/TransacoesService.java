package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.demo.model.TipoTransacaoModel;
import com.example.demo.model.TransacoesModel;
import com.example.demo.model.UsuarioModel;
@Service
public interface TransacoesService {

	public Boolean verificaSaldo(String nome, BigDecimal valortransacao);
	
	public void transferencia(String nome, String beneficiario, BigDecimal valortransacao, Integer qtdepagamento);
	
	public void deposito(String nome, String beneficiario, BigDecimal valorTransacao);
	
	public TransacoesModel verificaBeneficiado(BigDecimal valorTransacao, UsuarioModel beneficiado, TransacoesModel transacoesModel, TipoTransacaoModel tipoTransacaoModel, String nome);
	
}
