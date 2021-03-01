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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.enums.TipoContaEnums;
import com.example.demo.model.ContaModel;
import com.example.demo.model.TipoContaModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;
import com.example.demo.service.UsuarioServiceImpl;


@SpringBootTest
class UsuarioTest {

	@Mock
	private UsuarioRepository usuarioRepository;

	@InjectMocks
	private UsuarioServiceImpl usuarioServiceImpl;

	UsuarioModel usuarioModel1 = new UsuarioModel();
	UsuarioModel usuarioModel2 = new UsuarioModel();
	ContaModel contaModel = new ContaModel();
	TipoContaModel tipoContaModel = new TipoContaModel();
	List<UsuarioModel> retornarUsuarioModelList = new ArrayList<UsuarioModel>();
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	private Long idUsuario;

		
//		usuarioModel1.novoUsuario(1L, "tonho", formato.parse("12/01/1995"), "11.111.111-1", "111.111.111-11",
//				"11111-111", "Rua Oreiaça", "Jardim Oreia", "Oreiacity", "OÇ", "(11) 91111-1111", contaModel);
		
		
//		usuarioModel2.novoUsuario(2L, "Jipa", formato.parse("20/09/1990"), "22.222.222-2", "222.222.222-22",
//				"22222-222", "Rua Jipa", "Jardim Jipa", "Jipacity", "JP", "(11) 92222-2222", contaModel);
	
	@Before
	public void init() throws ParseException {
			
		usuarioModel1.setIdUsuario(1L);
		usuarioModel1.setNome("Tonho");
		usuarioModel1.setDtaDeNascimento(formato.parse("12/01/1995"));
		usuarioModel1.setRg("11.111.111-1");
		usuarioModel1.setCpf("111.111.111-11");
		usuarioModel1.setCep("11111-111");
		usuarioModel1.setEndereco("Rua Oreiaça");
		usuarioModel1.setBairro("Jardim Oreiaça");
		usuarioModel1.setCidade("Oreiacity");
		usuarioModel1.setEstado("OC");
		usuarioModel1.setTelefone("(11) 91111-1111");
		usuarioModel1.setContaModel(contaModel);
				
		usuarioModel2.setIdUsuario(2L);
		usuarioModel2.setNome("Jipa");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		usuarioModel2.setDtaDeNascimento(formato.parse("10/05/1999"));
		usuarioModel2.setRg("22.222.222-2");
		usuarioModel2.setCpf("222.222.222-22");
		usuarioModel2.setCep("22222-222");
		usuarioModel2.setEndereco("Rua Jipa");
		usuarioModel2.setBairro("Jardim Jipones");
		usuarioModel2.setCidade("Jipãocity");
		usuarioModel2.setEstado("JP");
		usuarioModel2.setTelefone("(11) 92222-2222");
		usuarioModel2.setContaModel(contaModel);
		
//		ContaModel.novaConta(1L, "11111111-1", "1111-1", new BigDecimal(5000.00), tipoContaModel);
		
		contaModel.setIdConta(1L);
		contaModel.setAgencia("1111-1");
		contaModel.setNumeroConta("11111111-1");
		contaModel.setSaldo(new BigDecimal (5000.00));
		contaModel.setTipoContaModel(tipoContaModel);
		
//		tipoContaModel.novoTipoConta(TipoContaEnums.CORRENTE.getId(), TipoContaEnums.CORRENTE.getNome());
		
		tipoContaModel.setIdTipoConta(TipoContaEnums.CORRENTE.getId());
		tipoContaModel.setNome(TipoContaEnums.CORRENTE.getNome());

	}


	@Test
	public void obterTodosUsuarios() {
	
		List<UsuarioModel> usuario1 = new ArrayList<UsuarioModel>();
		usuario1.add(usuarioModel1);
		Mockito.when(usuarioRepository.findAll()).thenReturn(usuario1);
		List<UsuarioModel> obterTodos = new ArrayList<>();
		obterTodos = usuarioServiceImpl.obterTodos();
		assertEquals(obterTodos, usuario1);
	}
	
	@Test
	public void ObterPorIdOK() {
		UsuarioModel usuarioModel1 = new UsuarioModel();
		usuarioModel1.setIdUsuario(1L);
		Mockito.when(usuarioRepository.obterPorID(usuarioModel1.getIdUsuario())).thenReturn(usuarioModel1);
		UsuarioModel obterPorID = usuarioServiceImpl.obterPorID(usuarioModel1.getIdUsuario());
		assertEquals(obterPorID, usuarioModel1);
	}


	@Test
	void contextLoads() {		
	}

}

