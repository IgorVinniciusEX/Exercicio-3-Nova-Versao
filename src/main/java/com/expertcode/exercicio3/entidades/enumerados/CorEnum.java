package com.expertcode.exercicio3.entidades.enumerados;

public enum CorEnum {

	PRETO("PRETO"),
	BRANCO("BRANCO"),
	AMARELO("AMARELO"),
	AZUL("AZUL"),
	PRATA("PRATA"),
	CINZA("CINZA"),
	VERDE("VERDE"),
	VERMELHO("VERMELHO");
	
	private String codigo;
	
	private CorEnum(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public static CorEnum pegarEnum(String codigo) {
		for(CorEnum valor : CorEnum.values()) {
			if(valor.getCodigo().equals(codigo)) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Código de Cor inválido!");
	}
}
