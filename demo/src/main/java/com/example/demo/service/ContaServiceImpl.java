package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ContaModel;
import com.example.demo.repository.ContaRepository;

@Service
public class ContaServiceImpl implements ContaService {

	@Autowired
	private ContaRepository contaRepository;

	public List<ContaModel> obterTudo() {
		return contaRepository.findAll();
	}

	public ContaModel obterContaPorNumero(String numeroConta) {
		return contaRepository.obterContaPorNumero(numeroConta);
	}

	public ContaModel obterContaPorId(Long idConta) {
		return contaRepository.obterContaPorId(idConta);
	}

	public BigDecimal obterSaldo(Long idConta) {
		ContaModel contaModel = contaRepository.obterContaPorId(idConta);
		return contaModel.getSaldo();
	}
	
	@Override
	public ContaModel salvarConta(ContaModel idConta) {
		return contaRepository.save(idConta);
	}
	public void  deletarConta(ContaModel idConta) {
			contaRepository.delete(idConta);
			
	}
	
}
