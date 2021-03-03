package com.example.demo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.enums.TipoContaEnums;
import com.example.demo.model.ContaModel;
import com.example.demo.model.TipoContaModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;
import com.example.demo.service.UsuarioServiceImpl;


@SpringBootTest
class UsuarioTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
		UsuarioModel usuarioModel1 = new UsuarioModel();
		UsuarioModel usuarioModel2 = new UsuarioModel();
		ContaModel contaModel = new ContaModel();
		TipoContaModel tipoContaModel = new TipoContaModel();
		List<UsuarioModel> retornarUsuarioModelList = new ArrayList<UsuarioModel>();
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


	@Test
	public void obterTodosUsuariosOK() {
		List<UsuarioModel> obterTodos = usuarioServiceImpl.obterTodos();
		assertEquals(2,obterTodos.size());
	}
	
	@Test
	public void ObterUsuarioPorIdOK() {
		usuarioModel1.setIdUsuario(2l);
		usuarioModel1.setNome("Jipão");
		Long idUsuario = 2l;
		UsuarioModel obterPorID = usuarioServiceImpl.obterPorID(idUsuario);
		assertEquals(usuarioModel1.getNome(), obterPorID.getNome());
	}

		
	@Test
	public void obterUsuarioPorNomeOK() {
		usuarioModel1.setNome("Jipão");
		usuarioModel1.setBairro("Jipão das Oliveiras");
		String nome = "Jipão";
		UsuarioModel obterPorNome = usuarioServiceImpl.obterPorNome(nome);
		assertEquals(usuarioModel1.getBairro(), obterPorNome.getBairro());
	}
	
		@Test
	public void obterUsuarioPorCPFOK() {
		usuarioModel1.setCpf("222.222.222-22");
		usuarioModel1.setBairro("Jipão das Oliveiras");
		String cpf = "222.222.222-22";
		UsuarioModel obterUsuarioPorCPF = usuarioServiceImpl.obterUsuarioPorCPF(cpf);
		assertEquals(usuarioModel1.getBairro(), obterUsuarioPorCPF.getBairro());
	}
	
	@Test
	public void obterUsuarioPorRGOK() {
		usuarioModel1.setRg("22.222.222-2");
		usuarioModel1.setBairro("Jipão das Oliveiras");
		String rg = "22.222.222-2";
		UsuarioModel obterUsuarioPorRG = usuarioServiceImpl.obterUsuarioPorRG(rg);
		assertEquals(usuarioModel1.getBairro(), obterUsuarioPorRG.getBairro());
	}

	@Test
	public void obterUsuarioPorEstadosOK() {
		List<UsuarioModel> usuario1 = new ArrayList<UsuarioModel>();
		String estado = "Jipóllis";
		List<UsuarioModel> obterPorEstado = new ArrayList<UsuarioModel>();
		obterPorEstado = usuarioServiceImpl.obterPorEstado(estado);
		
			for (UsuarioModel usuarioModel : obterPorEstado) {
				usuarioModel.getEstado();
				usuario1.add(usuarioModel);
			}
			assertEquals(usuario1, obterPorEstado);
		}
	
//	@Test
	public void obterUsuarioPorEstadosNotOK() {
		List<UsuarioModel> usuario1 = new ArrayList<UsuarioModel>();
		usuario1.add(null);
		Mockito.when(usuarioRepository.obterPorEstado(usuarioModel1.getEstado())).thenReturn(usuario1);
		List<UsuarioModel> obterPorEstado = new ArrayList<>();
		obterPorEstado = usuarioServiceImpl.obterPorEstado(usuarioModel1.getEstado());
		assertEquals(obterPorEstado, usuario1);
	}

//	@Test
	public void salvarUsuarioOK() {
		UsuarioModel usuarioModel1 = new UsuarioModel();
		usuarioModel1.setIdUsuario(1l);
		Mockito.when(usuarioRepository.save(usuarioModel1)).thenReturn(usuarioModel1);
		UsuarioModel salvarUser = usuarioServiceImpl.salvarUsuario(usuarioModel1);
		assertEquals(salvarUser, usuarioModel1);
	}
	
//	@Test
//	public void deletarUsuarioOK() {
//		UsuarioModel usuario1 = new UsuarioModel();
// 		usuario1 = 	usuarioServiceImpl.deletarUsuario(usuario1.getIdUsuario());
//	}
	
//	@Test
//	public void atualizarUsuarioOK() {
//		UsuarioModel usuario1 = new UsuarioModel();
//		usuario1 = usuarioRepository.obterPorID(idUsuario);
//		Mockito.when(usuarioRepository.save(usuario1)).thenReturn(usuario1);
//		UsuarioModel usuarioTeste = usuarioServiceImpl.atualizarUsuario(usuario1);
//		assertEquals(usuarioTeste, usuario1);
//	}
//	
	@Test
	void contextLoads() {	
		
	}
}

