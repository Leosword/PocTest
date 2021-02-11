package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.demo.model.UsuarioModel;



@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, String> {
	
	@Query("SELECT um FROM UsuarioModel um INNER JOIN fetch um.contaModel c WHERE um.cpf = :cpf")
	UsuarioModel obterUsuarioPorCPF(@Param("cpf") String cpf);
	
	@Query("SELECT um FROM UsuarioModel um INNER JOIN fetch um.contaModel c WHERE um.rg = :rg")
	UsuarioModel obterUsuarioPorRG(@Param("rg") String rg);

	@Query("SELECT um FROM UsuarioModel um INNER JOIN fetch um.contaModel c WHERE um.nome = :nome")
	UsuarioModel obterPorNome(@Param("nome") String nome);
	
	@Query("SELECT um FROM UsuarioModel um WHERE um.estado = :estado")
	List<UsuarioModel> obterPorEstado(@Param("estado") String estado);
	
	@Query("SELECT um FROM UsuarioModel um INNER JOIN fetch um.contaModel c WHERE um.idUsuario = :idUsuario")
	UsuarioModel ObterUsuarioEContaPorID(@Param("idUsuario") Long idUsuario);

}
