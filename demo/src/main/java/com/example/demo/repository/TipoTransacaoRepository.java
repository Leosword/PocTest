package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.TipoTransacaoModel;

@Repository
public interface TipoTransacaoRepository extends JpaRepository<TipoTransacaoModel, String> {
	
	
	

}
