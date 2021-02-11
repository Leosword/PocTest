package com.example.demo.repository;

import java.math.BigDecimal; 
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AuditoriaModel;



@Repository
public interface RepositoryAuditoria extends JpaRepository<AuditoriaModel, String> {

//	@Query("SELECT a FROM Auditoria a inner join fetch a.usuarioModel um WHERE a.acao = :acao")
//	Auditoria obterPorAcao(@Param("acao") String acao);
//
//	@Query("SELECT a FROM Auditoria a inner join fetch a.usuarioModel um WHERE a.data = :data")
//	Auditoria obterPorData(@Param("data") Date data);

	@Query("SELECT a FROM AuditoriaModel a inner join fetch a.usuarioModel um WHERE a.hora = :hora")
	AuditoriaModel obterPorHora(@Param("hora") Date hora);

	@Query("SELECT a FROM AuditoriaModel a inner join fetch a.usuarioModel um WHERE a.valor = :valor")
	AuditoriaModel obterPorValor(@Param("valor") String valor);
	
	@Query("SELECT a FROM AuditoriaModel a inner join fetch a.usuarioModel um WHERE a.novoValor = :novoValor")
	AuditoriaModel obterPorNovoValor(@Param("novoValor")BigDecimal novoValor);
	
	@Query("SELECT a FROM AuditoriaModel a inner join fetch a.usuarioModel um WHERE a.acao = :acao and a.data = :data ")
	List<AuditoriaModel> obterPorAcaoData(@Param("acao")String acao,@Param("data")Date data);
	
	@Query("SELECT a FROM AuditoriaModel a inner join fetch a.usuarioModel um WHERE a.data = :data and a.hora = :hora ")
	List<AuditoriaModel> obterPorDataHora(@Param("data")Date data,@Param("hora")Date hora);
	
//	@Query("SELECT a FROM Auditoria a inner join fetch a.usuarioModel um WHERE a.acao = :acao and a.hora = :hora and a.valor = :valor")
//	List<AuditoriaModel> obterPorAcaoHoraValor(@Param("acao")String acao,@Param("hora")Date hora,@Param("valor")String valor );
	
	
	
	
	
	
}
