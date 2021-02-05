package com.example.demo.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UsuarioModel;

@Repository
public interface UsuarioRepository {
	
	@Query("")
	UsuarioModel obterTodos();
}
