package com.example.demo.enums;

import lombok.Getter;


@Getter

public enum TipoDePagamentoEnums {
	AVISTA(1L, "Avista"), PARCELADO(2L, "Parcelado");

	public static TipoDePagamentoEnums get(Long id) {
		for (TipoDePagamentoEnums obj : TipoDePagamentoEnums.values()) {
			if (obj.getId().equals(id))
				return obj;
		}
		return null;
	}
	
	public static TipoDePagamentoEnums get(String nome) {
		for(TipoDePagamentoEnums obj : TipoDePagamentoEnums.values()) {
			if(obj.getNome().equals(nome))
				return obj;
			}
			return null;
		}

	Long id;
	String nome;

	TipoDePagamentoEnums(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
}
