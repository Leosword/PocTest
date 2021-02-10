package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TipoDePagamentoModel;

@Repository
public interface TipoDePagamentoRepository extends JpaRepository<TipoDePagamentoModel, String>{
	
//	@Query("INSERT INTO TipoDePagamentoModel(idTipoDePamento, nome, qtdePagamento) VALUES(:idTipoDePamento, :nome, :qtdePagamento )")
//	TipoDePagamentoModel addPagamento(@Param("idTipoDePamento") Long idTipoDePamento,@Param("nome") String nome ,@Param("qtdePagamento") String qtdePagamento);
//	
}
