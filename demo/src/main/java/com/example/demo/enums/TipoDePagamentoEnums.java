package com.example.demo.enums;

public enum TipoDePagamentoEnums {
	AVISTA(1), PARCELADO(2);
	
	public static TipoDePagamentoEnums get(Integer id) {
		for(TipoDePagamentoEnums obj : TipoDePagamentoEnums.values()) {
			if(obj.getId().equals(id))
				return obj;
		}
		return null;
		
	}
	
	Integer id;
	
	public Integer getId() {
		return id;
	}
	

	
	TipoDePagamentoEnums(Integer id){
		this.id = id;
	}
}
