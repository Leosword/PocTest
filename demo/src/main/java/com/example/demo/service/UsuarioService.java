package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UsuarioModel;

public interface UsuarioService {
	
	List<UsuarioModel> obterTodos();

	List<UsuarioModel>obterPorEstado();

	List<UsuarioModel> obterContaETipoPorNome();	
	
	List<UsuarioModel> obterTudo();
}
