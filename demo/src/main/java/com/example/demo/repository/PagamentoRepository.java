package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PagamentoModel;


@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoModel, String> {
	
//	@Query("SELECT p FROM PagamentoModel p Inner Join p.TipoDePagamentoModel tpm WHERE p.idPag = :idPag")
//	PagamentoModel obterPagPorId(@Param("idPag") Long idPag);
//	
//	@Query("SELECT p FROM PagamentoModel p Inner Join p.TipoDePagamentoModel tpm WHERE p.dataPag = :dataPag")
//	List <PagamentoModel> obterPagPorData(@Param("dataPag") Date dataPag);
	
	
}
