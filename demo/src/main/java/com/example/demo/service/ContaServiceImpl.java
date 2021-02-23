package com.example.demo.service;

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

	public ContaModel obterContaPorAgencia(String agencia) {
		return contaRepository.obterContaPorAgencia(agencia);

	}

	public ContaModel obterContaPorNumeroEAgencia(String conta, String agencia) {
		return contaRepository.obterContaeTipoPorNumeroEAgencia(conta, agencia);
	}

	public ContaModel obterContaeTipoPorNumeroEAgencia(String numeroConta, String agencia) {
		return contaRepository.obterContaeTipoPorNumeroEAgencia(numeroConta, agencia);

	}
}
