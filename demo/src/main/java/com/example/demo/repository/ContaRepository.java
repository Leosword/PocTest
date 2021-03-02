package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ContaModel;

@Repository
public interface ContaRepository extends JpaRepository<ContaModel, String> {

	@Query("SELECT c FROM ContaModel c  WHERE c.idConta = :idConta")
	ContaModel obterContaPorId(@Param("idConta") Long idConta);

	@Query("SELECT c FROM ContaModel c inner join UsuarioModel u  WHERE c.numeroConta = :numeroConta")
	ContaModel obterContaPorNumero(@Param("numeroConta") String numeroConta);

	@Query("SELECT c FROM ContaModel c inner join UsuarioModel u  WHERE c.agencia = :agencia")
	<List> ContaModel obterContaPorAgencia(@Param("agencia") String agencia);

	@Query("SELECT c FROM ContaModel c inner join UsuarioModel u  WHERE c.numeroConta = :numeroConta and c.agencia = :agencia")
	ContaModel obterContaPorNumeroEAgencia(@Param("numeroConta") String numeroConta, @Param("agencia") String agencia);

	@Query("SELECT c FROM ContaModel c inner join TipoContaModel u  WHERE c.numeroConta = :numeroConta and c.agencia = :agencia")
	ContaModel obterContaeTipoPorNumeroEAgencia(@Param("numeroConta") String numeroConta,@Param("agencia") String agencia);

}
