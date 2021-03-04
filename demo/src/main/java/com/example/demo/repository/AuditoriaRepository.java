package com.example.demo.repository;


import java.math.BigDecimal; 
import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AuditoriaModel;

@Repository
public interface AuditoriaRepository extends JpaRepository<AuditoriaModel, String> {

	@Query("SELECT a FROM AuditoriaModel a Inner Join fetch a.usuarioModel um WHERE a.acao = :acao")
	List<AuditoriaModel> obterPorAcao(@Param("acao") String acao);

	@Query("SELECT a FROM AuditoriaModel a Inner Join fetch a.usuarioModel um WHERE um.idUsuario = :idUsuario")
	List<AuditoriaModel> obterPoridUsuario(@Param("idUsuario")Long idUsuario);

	@Query("SELECT a FROM AuditoriaModel a Inner Join fetch a.usuarioModel um WHERE a.data = :data and a.hora = :hora")
	List<AuditoriaModel>obterPorDataHora(@Param("data")Date data,@Param("hora")Date hora);
	
	@Query("SELECT a FROM AuditoriaModel a Inner Join fetch a.usuarioModel um WHERE a.acao = :acao and a.data = :data and a.hora = :hora ")
	List<AuditoriaModel>obterPorAcaoDataHora(@Param("acao")String acao,@Param("data")Date data,@Param("hora")Date hora);
	
	@Query("SELECT a FROM AuditoriaModel a Inner Join fetch a.usuarioModel um WHERE um.idUsuario = :idUsuario and a.data = :data")
	List<AuditoriaModel>obterPoridUsuarioData(@Param("idUsuario")Long idUsuario,@Param("data")Date data);
	
	List<AuditoriaModel>findAll();
	
	
}
