package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TransacoesModel;
@Repository
public interface TransacoesReporsitory extends JpaRepository<TransacoesModel, String> {
	
	
	// Transações por usuarios
	@Query("SELECT t FROM TransacoesModel t Inner Join Fetch t.usuarioModel um WHERE um.nome = :nome")
	List<TransacoesModel> obterTrasacoesUsuario(@Param("nome") String nome);
	
	
	@Query("SELECT t FROM TransacoesModel t Inner Join Fetch t.usuarioModel um WHERE t.beneficiario = :beneficiario")
	List<TransacoesModel> obterTrasacoesbeneficiado(@Param("beneficiario") Long beneficiario);
	
	
	@Query("SELECT t FROM TransacoesModel t Inner Join Fetch t.usuarioModel um WHERE t.dataTransacao = :dataTransacao and um.nome = :nome")
	List<TransacoesModel> obterTrasacoesUsuarioData(@Param("dataTransacao") Date dataTransacao, @Param("nome") String nome);
	
	
	
	
	//Transações por Data
	@Query("SELECT t FROM TransacoesModel t Inner Join Fetch t.usuarioModel um WHERE t.dataTransacao = :dataTransacao")
	List<TransacoesModel> obterTrasacoesPorData(@Param("dataTransacao") Date dataTransacao);
		
	@Query("SELECT t FROM TransacoesModel t Inner Join Fetch t.usuarioModel um WHERE t.dataTransacao BETWEEN :dataInicial and :dataFinal")
	List<TransacoesModel> obterTrasacoesPorPeriodo(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);
	
	
	//Transações por valor	
	@Query("SELECT t FROM TransacoesModel t Inner Join Fetch t.usuarioModel um WHERE t.valorTransacao = :valorTransacao")
	List<TransacoesModel> obterTrasacoesPorValorEspecifico(@Param("valorTransacao") BigDecimal valorTransacao);
	
	@Query("SELECT t FROM TransacoesModel t Inner Join Fetch t.usuarioModel um WHERE t.valorTransacao <= :valorTransacao")
	List<TransacoesModel> obterTrasacoesPorValorMenor(@Param("valorTransacao") BigDecimal valorTransacao);
	
	
	@Query("SELECT t FROM TransacoesModel t Inner Join Fetch t.usuarioModel um WHERE t.valorTransacao >= :valorTransacao")
	List<TransacoesModel> obterTrasacoesPorValorMaior(@Param("valorTransacao") BigDecimal valorTransacao);
	
	
	
	//Transações por valor	e data
	@Query("SELECT t FROM TransacoesModel t Inner Join Fetch t.usuarioModel um WHERE t.dataTransacao = :dataTransacao and t.valorTransacao = :valorTransacao ")
	List<TransacoesModel> obterTrasacoesPorDataValor(@Param("dataTransacao") Date dataTransacao, @Param("valorTransacao") BigDecimal valorTransacao);
	
	@Query("SELECT t FROM TransacoesModel t Inner Join Fetch t.usuarioModel um WHERE t.valorTransacao >= :valorTransacao and t.dataTransacao BETWEEN :dataInicial and :dataFinal")
	List<TransacoesModel> obterTrasacoesEntreDataValorMaior(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal, @Param("valorTransacao") BigDecimal valorTransacao);
	
	
	@Query("SELECT t FROM TransacoesModel t Inner Join Fetch t.usuarioModel um WHERE t.valorTransacao <= :valorTransacao and t.dataTransacao BETWEEN :dataInicial and :dataFinal")
	List<TransacoesModel> obterTrasacoesEntreDataValorMenor(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal, @Param("valorTransacao") BigDecimal valorTransacao);
	
}