package com.expertcode.exercicio3.servicos.excecoes;

public class BancoDeDadosExcecao extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BancoDeDadosExcecao (String msg){
        super(msg);
    }
}
