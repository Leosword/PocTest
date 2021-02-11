package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ContaModel;

@Repository
public interface ContaRepository extends JpaRepository<ContaModel, Long>{
	
	@Query("SELECT c FROM ContaModel c inner join fetch UsuarioModel u INNER JOIN TipoContaModel WHERE c.idConta = :idConta")
	ContaModel obterContaPorId(@Param("idConta") Long idConta); 
	


}
