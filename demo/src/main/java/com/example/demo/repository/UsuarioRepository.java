package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UsuarioModel;

import antlr.collections.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, String> {

	@Query("SELECT um FROM UsuarioModel um WHERE um.nome = :nome")
	UsuarioModel obterTodos(@Param("nome") String nome);
	
	@Query("SELECT um FROM UsuarioModel um WHERE um.estado = :estado")
	UsuarioModel obterPorEstado(@Param("estado") String estado);
	
	@Query("SELECT um FROM UsuarioModel um WHERE um.cpf = :cpf")
	UsuarioModel obterPorCPF(@Param("cpf") String cpf);
	
	@Query("SELECT um FROM UsuarioModel um WHERE um.rg = :rg")
	UsuarioModel obterPorRG(@Param("rg") String rg);
	
	
	
	@Query("SELECT um"
			+ " FROM UsuarioModel um inner Join TipoContaModel tcm inner join ContaModel cm WHERE um.nome = :nome")
	UsuarioModel obterContaETipoPorNome(@Param("nome") String nome);
	
	@Query("SELECT um "
			+ " FROM UsuarioModel um inner Join TipoContaModel tcm inner join ContaModel cm WHERE um.idUsuario = :idUsuario")
	UsuarioModel ObterContaETipoPorID(@Param("idUsuario") Long idUsuario);

//	@Query("SELECT um " 
//			+ "FROM UsuarioModel um INNER JOIN TipoContaModel tcm INNER JOIN ContaModel cm INNER JOIN Transacoes t INNER JOIN TipoTransacao tt "
//			+ "INNER JOIN TipoDePagamento tp INNER JOIN TipoDeProdutoModel tdpm "
//			+ "WHERE um.nome = :nome")
//	UsuarioModel obterTudo(@Param("nome") String nome);
	
	
	
	
//	@Query("INSERT INTO UsuarioModel (nome, dtaDeNascimento, rg, cpf, cep, endereco, bairro, cidade, estado, telefone "
//									+ " VALUES ('Tonho','1997-10-10','11.111.111-1','111.111.111-1','11111-111', Rua Tonho Milos',"
//									+ "'Tonhoville', 'Tonhonópolis','(11)1111-1111'")

}
