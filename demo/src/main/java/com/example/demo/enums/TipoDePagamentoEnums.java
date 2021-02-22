package com.example.demo.enums;

import lombok.Getter;


@Getter

public enum TipoDePagamentoEnums {
	AVISTA(1, "Avista"), PARCELADO(2, "Parcelado");

	public static TipoDePagamentoEnums get(Integer id) {
		for (TipoDePagamentoEnums obj : TipoDePagamentoEnums.values()) {
			if (obj.getId().equals(id))
				return obj;
		}
		return null;
	}

	Integer id;
	String nome;

	TipoDePagamentoEnums(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
}
