package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UsuarioModel;

public interface UsuarioService {
	
	List<UsuarioModel> obterTodos();

	public UsuarioModel obterPorNome(String nome);

	public UsuarioModel obterUsuarioPorCPF(String cpf);

	public UsuarioModel obterUsuarioPorRG(String tg);

	public List<UsuarioModel> obterPorEstado(String estado);
	
	public UsuarioModel obterPorID(Long idUsuario);
	
	UsuarioModel salvarUsuario(UsuarioModel idUsuario);
	
	void deletarUsuario(UsuarioModel idUsuario);

	
	

	

	
}
