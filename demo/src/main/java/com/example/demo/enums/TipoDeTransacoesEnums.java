package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum TipoDeTransacoesEnums {
	
	DEPOSITO(1, "Deposito"), PAGAMENTO(2, "Pagamento"), TRANSFERENCIA(3,"Transferencia");
	


	public static TipoDeTransacoesEnums get(Integer id) {
		for (TipoDeTransacoesEnums obj : TipoDeTransacoesEnums.values()) {
			if (obj.getId().equals(id))
				return obj;
		}
		return null;
	}

	Integer id;
	String nome;

	TipoDeTransacoesEnums(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

}
