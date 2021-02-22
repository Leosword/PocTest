package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
		
	public List<UsuarioModel> obterTodos() {
		return usuarioRepository.findAll();
	}
		
	public UsuarioModel obterPorID(Long idUsuario){
		return usuarioRepository.obterPorID(idUsuario);
	}
	
	public UsuarioModel obterPorNome(String nome){
		return usuarioRepository.obterPorNome(nome);
	}
	
	public List<UsuarioModel> obterPorEstado(String estado){
			return usuarioRepository.obterPorEstado(estado);
	}
	
	
	public UsuarioModel obterUsuarioPorCPF(String cpf){
		return usuarioRepository.obterUsuarioPorCPF(cpf);
	}
	
	public UsuarioModel obterUsuarioPorRG(String rg){
		return usuarioRepository.obterUsuarioPorRG(rg);
	}
	
		
	@Override
	public UsuarioModel salvarUsuario(UsuarioModel idUsuario) {
		return usuarioRepository.save(idUsuario);
	}

	public void deletarUsuario(UsuarioModel idUsuario) {
		usuarioRepository.delete(idUsuario);
		
	}

	
	





}
