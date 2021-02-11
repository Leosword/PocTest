package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TipoContaModel;

@Repository

public interface TipoContaRepository extends JpaRepository<TipoContaModel, String>{

//	@Query("SELECT tc FROM TipoConta tc inner join ContaModel c  WHERE tc.idTipoConta = :idTipoConta")
//	TipoContaModel obterTipoContaPorId(@Param("idTipoConta") Long idTipoConta);

//	@Query("SELECT tc FROM TipoConta tc inner join ContaModel c WHERE tc.nome = :nome")
//	List<TipoContaModel> obterTipoContaPorNome(@Param("nome") String nome);

}
