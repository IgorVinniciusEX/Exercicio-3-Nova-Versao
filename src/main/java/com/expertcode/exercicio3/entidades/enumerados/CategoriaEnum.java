package com.expertcode.exercicio3.entidades.enumerados;

public enum CategoriaEnum {

	MOTOCICLETA("MOTOCICLETA"),
	CARRO("CARRO"),
	CAMINHAO("CAMINHAO");
	
	private String codigo;
	
	private CategoriaEnum(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public static CategoriaEnum pegarEnum(String codigo) {
		for(CategoriaEnum valor : CategoriaEnum.values()) {
			if(valor.getCodigo().equals(codigo)) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Código de Categoria inválido!");
	}
}
