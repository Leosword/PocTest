package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.h2.expression.function.ToDateParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.enums.TipoContaEnums;
import com.example.demo.enums.TipoDePagamentoEnums;
import com.example.demo.enums.TipoDeProdutoEnums;
import com.example.demo.model.ContaModel;
import com.example.demo.model.TipoContaModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;
import com.example.demo.service.UsuarioServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UsuarioTeste {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;
    
    @Autowired
    private UsuarioService usuarioService;
    
   
    @Autowired
    private ContaModel contaModel;

    @Autowired
	private UsuarioModel usuarioModel1;
    
    @Autowired
	private UsuarioModel usuarioModel2;
    
    @Autowired
	private TipoContaModel tipoContaModel;
    
    @Autowired
    private TipoContaEnums tipoContaEnums;
    
       
    @Before
    public void init() throws ParseException {
	   
	    
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		usuarioModel1.novoUsuario(1L, "tonho", formato.parse("12/01/1995"), "11.111.111-1", "111.111.111-11",
				"11111-111", "Rua Oreiaça", "Jardim Oreia", "Oreiacity", "OÇ", "(11) 91111-1111", contaModel);
		
		usuarioModel2.novoUsuario(2L, "Jipa", formato.parse("20/09/1990"), "22.222.222-2", "222.222.222-22",
				"22222-222", "Rua Jipa", "Jardim Jipa", "Jipacity", "JP", "(11) 92222-2222", contaModel);
		
		contaModel.novaConta(1L, "11111111-1", "1111-1", new BigDecimal(5000.00), tipoContaModel);
		
		tipoContaModel.novoTipoConta(TipoContaEnums.CORRENTE.getId(), tipoContaEnums.getNome());
    
    }

	
    	
    	
    	
    
	
    
}
