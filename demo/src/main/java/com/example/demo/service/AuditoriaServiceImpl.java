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

	
}
