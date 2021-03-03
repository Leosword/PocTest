package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.ContaModel;
import com.example.demo.model.TipoContaModel;
import com.example.demo.model.TransacoesModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.service.ContaServiceImpl;
import com.example.demo.service.TransacoesServiceImpl;
import com.example.demo.service.UsuarioService;

@SpringBootTest
public class TransacoesTest {
	
	@Autowired
	private TransacoesServiceImpl transacoesServiceImpl;
	
	@Autowired
	private ContaServiceImpl contaServiceImpl;
	
	@Autowired
	private UsuarioService usuarioServiceImpl;
	
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
	@Test
	public void testarDeposito(){
		Long usuario = 3L;
		BigDecimal valorTransacao = new BigDecimal(100);
	
		
		BigDecimal usuarioOld = contaServiceImpl.obterSaldo(usuario);		
		transacoesServiceImpl.deposito(usuario, valorTransacao);
		BigDecimal usuarioNew = contaServiceImpl.obterSaldo(usuario);
	
		
		assertEquals(new BigDecimal(190500).stripTrailingZeros(), usuarioOld.stripTrailingZeros());
		assertEquals(new BigDecimal(190600).stripTrailingZeros(), usuarioNew.stripTrailingZeros());

		
	}
	
	@Test
	public void testarTransferencia() {
		Long idUsuario = 3L;
		Long idBeneficiario = 2L;
		BigDecimal valorTransacao = new BigDecimal(100);
		
		
		
		BigDecimal usuarioOld = contaServiceImpl.obterSaldo(idUsuario);
		BigDecimal beneficiarioOld = contaServiceImpl.obterSaldo(idBeneficiario);
		transacoesServiceImpl.transferencia(idUsuario, idBeneficiario, valorTransacao);	
		BigDecimal usuarioNew = contaServiceImpl.obterSaldo(idUsuario);
		BigDecimal beneficiarioNew = contaServiceImpl.obterSaldo(idBeneficiario);
		
		assertEquals(new BigDecimal(190500).stripTrailingZeros(), usuarioOld.stripTrailingZeros());
		assertEquals(new BigDecimal(5500).stripTrailingZeros(), beneficiarioOld.stripTrailingZeros());
		assertEquals(new BigDecimal(190400).stripTrailingZeros(), usuarioNew.stripTrailingZeros());
		assertEquals(new BigDecimal(5600).stripTrailingZeros(), beneficiarioNew.stripTrailingZeros());
		
	}
	
	

}
