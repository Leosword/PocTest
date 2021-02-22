package com.example.demo.enums;

public enum TipoDeTransacoesEnums {
	
	DEPOSITO(1), PAGAMENTO(2), TRANSFERENCIA(3), EMPRESTIMO(4);
	


	public static TipoDeTransacoesEnums get(Integer id) {
		for (TipoDeTransacoesEnums obj : TipoDeTransacoesEnums.values()) {
			if (obj.getId().equals(id))
				return obj;
		}
		return null;
	}

	Integer id;

	public Integer getId() {
		return id;
	}

	TipoDeTransacoesEnums(Integer id) {
		this.id = id;
	}

}
