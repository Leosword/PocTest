package com.example.demo.repository;

import java.math.BigDecimal; 
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AuditoriaModel;



@Repository
public interface AuditoriaRepository extends JpaRepository<AuditoriaModel, String> {
	
	@Query("SELECT a FROM AuditoriaModel a Inner Join a.usuarioModel um WHERE a.acao = :acao")
	AuditoriaModel obterPorAcao(@Param("acao")String acao);
	
	
	@Query("SELECT a FROM AuditoriaModel a Inner Join fetch a.usuarioModel um WHERE a.acao = :acao and a.data = :data")
	List<AuditoriaModel> obterPorAcaoData(@Param("acao")String acao,@Param("data")Date data);
	
	@Query("SELECT a FROM AuditoriaModel a Inner Join fetch a.usuarioModel um WHERE a.valor = :valor and a.data = :data")
	List<AuditoriaModel> obterPorValorData(@Param("valor")BigDecimal valor,@Param("data")Date data);
	
	@Query("SELECT a FROM AuditoriaModel a Inner Join fetch a.usuarioModel um WHERE um.nome = :nome")
	AuditoriaModel obterPorNome(@Param("nome")String nome);
	
	@Query("SELECT a FROM AuditoriaModel a Inner Join fetch a.usuarioModel um WHERE a.acao = :acao and um.cpf = :cpf")
	List<AuditoriaModel>obterPorAcaoCpf(@Param("acao")String acao,@Param("cpf")String cpf);
}
