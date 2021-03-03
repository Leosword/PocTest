package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.demo.model.TipoTransacaoModel;

@Repository
public interface TipoTransacaoRepository extends JpaRepository<TipoTransacaoModel, String> {
	
	
	@Query("Select tp FROM TipoTransacaoModel tp WHERE tp.idTipoTransacao = :idTipoTransacao")
	TipoTransacaoModel obterTransacaoPorID(@Param("idTipoTransacao") Long idTipoTransacao);
	

}
