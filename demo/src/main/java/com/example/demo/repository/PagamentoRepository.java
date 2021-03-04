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
	
@Query("SELECT pm FROM PagamentoModel pm WHERE qtdePagamento > 1")
PagamentoModel obterTodosParcelados();

@Query("SELECT pm FROM PagamentoModel pm WHERE pm.idPag = :idPag ")
PagamentoModel obterPagamentoId(@Param("idPag") Long idPag);


}
