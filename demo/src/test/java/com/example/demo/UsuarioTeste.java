package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    private UsuarioModel usuarioModel;
    
    @Before
    public void init() {
	    MockitoAnnotations.initMocks(this);
	    when(usuarioModel.getIdUsuario()).thenReturn(1L);
	    when(usuarioModel.getNome()).thenReturn("Tonho");
	    when(usuarioModel.getEndereco()).thenReturn("Rua.Tonho de Hahaha Free Gels");
	    when(usuarioModel.getBairro()).thenReturn("Oreiacity");
	    when(usuarioModel.getCidade()).thenReturn("Oreiópolis");
	    when(usuarioModel.getEstado()).thenReturn("OA");
	    when(usuarioModel.getCep()).thenReturn("11111-111");
	    when(usuarioModel.getCpf()).thenReturn("111.111.111-11");
	    when(usuarioModel.getRg()).thenReturn("11.111.111-1");
	    when(usuarioModel.getDtaDeNascimento()).thenReturn('2002-06-24');
	    when(usuarioModel.getTelefone()).thenReturn("11111-111");
	    
       }
    
    
    
    @Test
	public UsuarioServiceImpl obterPorID() {
    	
    	
    	
    }
	
    
}
