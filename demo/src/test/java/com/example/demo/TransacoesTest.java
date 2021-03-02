package com.example.demo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.enums.TipoContaEnums;
import com.example.demo.model.ContaModel;
import com.example.demo.model.TipoContaModel;
import com.example.demo.model.TransacoesModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.TransacoesReporsitory;
import com.example.demo.service.TransacoesServiceImpl;
import com.sun.el.parser.ParseException;

@SpringBootTest
public class TransacoesTest {
	
	@Mock
	private TransacoesReporsitory transacoesRepository;
	
	@InjectMocks
	private TransacoesServiceImpl transacoesServiceImpl;
	
	UsuarioModel usuarioModel1 = new UsuarioModel();
	UsuarioModel usuarioModel2 = new UsuarioModel();
	TransacoesModel transacoesModel1 = new TransacoesModel();
	TransacoesModel transacoesModel2 = new TransacoesModel();
	ContaModel contaModel = new ContaModel();
	TipoContaModel tipoContaModel = new TipoContaModel();
	List<UsuarioModel> retornarUsuarioModelList = new ArrayList<UsuarioModel>();
	
	

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	
	
	@Before
	public void init() throws ParseException, java.text.ParseException{
		
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
		
		
		
	
		
		
				
		transacoesModel1.setIdTransacoes(1L);
		transacoesModel1.setValorTransacao(new BigDecimal(500.00));
		transacoesModel1.setDataTransacao(formato.parse("21/05/2020"));
		transacoesModel1.setBeneficiario("Tonho");
		transacoesModel1.setUsuarioModel(usuarioModel1);
		
		
		
		
		
		
		
		
		
		
	}
	
	@Test
	public void listarTransacoes() {
		List<TransacoesModel> obterTrasacoesIdUsuario = transacoesRepository.obterTrasacoesIdUsuario(1L);
		Integer obterTrasacoesIdUsuari1 = 1;
		
		
	}

}
