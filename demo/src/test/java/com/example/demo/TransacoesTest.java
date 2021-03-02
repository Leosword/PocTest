package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.enums.TipoContaEnums;
import com.example.demo.model.ContaModel;
import com.example.demo.model.TipoContaModel;
import com.example.demo.model.TransacoesModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.TransacoesReporsitory;
import com.example.demo.service.ContaServiceImpl;
import com.example.demo.service.TransacoesServiceImpl;
import com.sun.el.parser.ParseException;

@SpringBootTest
public class TransacoesTest {
	
	@Autowired
	private TransacoesServiceImpl transacoesServiceImpl;
	
	@Autowired
	private ContaServiceImpl contaServiceImpl;
	
	UsuarioModel usuarioModel1 = new UsuarioModel();
	UsuarioModel usuarioModel2 = new UsuarioModel();
	TransacoesModel transacoesModel1 = new TransacoesModel();
	TransacoesModel transacoesModel2 = new TransacoesModel();
	ContaModel contaModel = new ContaModel();
	TipoContaModel tipoContaModel = new TipoContaModel();
	List<UsuarioModel> retornarUsuarioModelList = new ArrayList<UsuarioModel>();
	
	

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	
	@Test
	public void testarSaque() {
		Long idConta = 2L;
		BigDecimal valorTransacao = new BigDecimal(100);
		
		BigDecimal obterSaldoOld = contaServiceImpl.obterSaldo(idConta);
		transacoesServiceImpl.saque(idConta, valorTransacao);
		BigDecimal obterSaldoNew = contaServiceImpl.obterSaldo(idConta);

		assertEquals(new BigDecimal(5500).stripTrailingZeros(), obterSaldoOld.stripTrailingZeros());
		assertEquals(new BigDecimal(5400).stripTrailingZeros(), obterSaldoNew.stripTrailingZeros());
				
		
	}
	

}
