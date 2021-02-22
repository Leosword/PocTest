package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.hql.internal.ast.tree.IsNotNullLogicOperatorNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.model.ContaModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	public List<UsuarioModel> obterTodos() {
		return usuarioRepository.findAll();
	}
	
	public UsuarioModel ObterPorID(Long idUsuario){
		UsuarioModel usuarioModel = usuarioRepository.obterPorID(idUsuario);
		return usuarioModel;
	}
	

	@Override
	public void salvarUsuario(UsuarioModel idUsuario) {
		usuarioRepository.save(idUsuario);
	}

	public void deletarUsuario(UsuarioModel idUsuario) {
		usuarioRepository.delete(idUsuario);
		
	}








}
