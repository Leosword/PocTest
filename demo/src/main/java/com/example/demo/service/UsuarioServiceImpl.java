package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enums.TipoDePagamentoEnums;
import com.example.demo.enums.TipoDeTransacoesEnums;
import com.example.demo.model.TipoDePagamentoModel;
import com.example.demo.model.TipoTransacaoModel;
import com.example.demo.model.TransacoesModel;
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
	
	
	public UsuarioModel atualizarUsuario(UsuarioModel usuarioModelTela) {
			UsuarioModel usuarioModel = usuarioRepository.obterPorID(usuarioModelTela.getIdUsuario());
			if(usuarioModel.getIdUsuario() == null) {
				System.out.println("Id não encontrado");
			}
			
			else if(!usuarioModel.equals(usuarioModelTela) ) {
				return usuarioRepository.save(usuarioModelTela);
			}
			
			return usuarioModel;
		}
	
	
	
	
}
