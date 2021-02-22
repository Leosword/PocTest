package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UsuarioModel;

public interface UsuarioService {
	
	List<UsuarioModel> obterTodos();	
	
	void salvarUsuario(UsuarioModel idUsuario);
	
	void deletarUsuario(UsuarioModel idUsuario);
	

	
}
