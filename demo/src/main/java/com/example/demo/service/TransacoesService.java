package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.TipoTransacaoModel;
import com.example.demo.model.TransacoesModel;
import com.example.demo.model.UsuarioModel;
@Service
public interface TransacoesService {

	public Boolean verificaSaldo(String nome, BigDecimal valortransacao);
	
	public void transferencia(Long idUsuario, Long idBeneficiario, BigDecimal valortransacao);
	
	public void deposito(Long idUsuario, BigDecimal valorTransacao);
	
	public TransacoesModel verificaBeneficiado(BigDecimal valorTransacao, UsuarioModel beneficiado, TransacoesModel transacoesModel, TipoTransacaoModel tipoTransacaoModel, String nome);
	
	public void saque(Long idUsuario, BigDecimal valorTransacao);
	
	public List<TransacoesModel> extrato(Long idUsuario, Date periodoInicial, Date periodoFinal);
	
	
}
