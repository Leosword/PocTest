package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TipoDePagamentoModel;

@Repository
public interface TipoDePagamentoRepository extends JpaRepository<TipoDePagamentoModel, String>{
	

	@Query("Select tp FROM TipoDePagamentoModel tp WHERE tp.idTipoDePamento = :idTipoDePamento")
	TipoDePagamentoModel obterTipoId(@Param("idTipoDePamento")Long idTipoDePamento);
		
}
