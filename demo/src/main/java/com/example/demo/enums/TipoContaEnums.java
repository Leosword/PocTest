package com.example.demo.enums;

public enum TipoContaEnums {
	CORRENTE(1L, "Corrente"), POUPANCA(2L, "Poupança"), SALARIO(3L, "Salário");

	public static TipoContaEnums get(Long id) {
		for(TipoContaEnums obj : TipoContaEnums.values()) {
			if(obj.getId().equals(id))
				return obj;
			}
			return null;
		}
	
	public static TipoContaEnums get(String nome) {
		for(TipoContaEnums obj : TipoContaEnums.values()) {
			if(obj.getNome().equals(nome))
				return obj;
			}
			return null;
		}
	
	Long id;
	
	String nome;
	
	public Long getId() {
		return id;
	}
	
	public  String getNome() {
		return nome;
	}
	

	TipoContaEnums(Long id, String nome){
		this.id = id;
		this.nome = nome;
	}
}
