package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TipoDeProdutoModel;

@Repository
public interface TipoDeProdutoRepository extends JpaRepository<TipoDeProdutoModel, String>{
	
	@Query("SELECT tp FROM TipoDeProdutoModel tp INNER JOIN UsuarioModel u INNER JOIN ContaModel c INNER JOIN TipoContaModel "
			+ "WHERE tp.idProduto = :idProduto")
	TipoDeProdutoModel obterProdutoPorID(@Param("idProduto") Long idProduto);
	
	@Query("SELECT tp FROM TipoDeProdutoModel tp INNER JOIN ContaModel c INNER JOIN UsuarioModel u INNER JOIN TipoContaModel tc "
			+ "WHERE tp.nome = :nome")
	List<TipoDeProdutoModel> obterProdutoPorNome(@Param("nome") String nome);
	

}
