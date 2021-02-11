package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ContaModel;
import com.example.demo.repository.ContaRepository;


@Service
public class ContaServiceImpl implements ContaService{
	
	@Autowired
	private ContaRepository contaRepository;
	
	public List<ContaModel> obterContaPorId() {
		return contaRepository.findAll();
	}
	

}
