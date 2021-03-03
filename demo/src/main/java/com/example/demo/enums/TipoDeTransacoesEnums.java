package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum TipoDeTransacoesEnums {
	
	DEPOSITO(1L, "Deposito"), PAGAMENTO(2L, "Pagamento"), TRANSFERENCIA(3L,"Transferencia"), SAQUE(4L, "Saque");
	


	public static TipoDeTransacoesEnums get(Long id) {
		for (TipoDeTransacoesEnums obj : TipoDeTransacoesEnums.values()) {
			if (obj.getId().equals(id))
				return obj;
		}
		return null;
	}

	Long id;
	String nome;

	TipoDeTransacoesEnums(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

}
