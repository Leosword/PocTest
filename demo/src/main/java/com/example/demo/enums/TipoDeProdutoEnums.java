package com.example.demo.enums;

public enum TipoDeProdutoEnums {
	
		PREVIDENCIA(1, "Previdência"), CHEQUE(2, "Cheque"), CARTAO(3, "Cartão"), 
		CAPITALIZACAO(4, "Capitalização"), INVESTIMENTOS(5,"Investimentos"), CONSORCIO(6,"Consórcio"),
		FINANCIAMENTOS(7, "Financiamentos");
		
				
		public static TipoDeProdutoEnums get(Integer id) {
			for(TipoDeProdutoEnums obj : TipoDeProdutoEnums.values()) {
				if(obj.getId().equals(id))
					return obj;
				}
				return null;
			}
		
		public static TipoDeProdutoEnums get(String nome) {
			for(TipoDeProdutoEnums obj : TipoDeProdutoEnums.values()) {
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
		

		TipoDeProdutoEnums(Integer id, String nome){
			this.id = id;
			this.nome = nome;
		}
	}



