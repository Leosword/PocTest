package com.example.demo.enums;

public enum TipoContaEnums {
	CORRENTE(1, "Corrente"), POUPANCA(2, "Poupança"), SALARIO(3, "Salário");

	public static TipoContaEnums get(Integer id) {
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
	
	Integer id;
	
	String nome;
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	

	TipoContaEnums(Integer id, String nome){
		this.id = id;
		this.nome = nome;
	}
}
