package com.expertcode.exercicio3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio3Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercicio3Application.class, args);
	}

}
/* EXERCÍCIO 3
CRUD de todas as tabelas, DTO e Exceptions

Em Categoria deve armazenar os tipos de veículo. Deve ser criado um Enum com as opções: MOTOCICLETA, CARRO, CAMINHAO. > OK
Deve ser armazenado o identificador da categoria e tipo que é a referência deste enum. Deve ser inserido diretamente no banco estes dados. Ex: 1 - CAMINHAO

O Veículo possui um relacionamento com Categoria e Marca. 
O Veículo irá possuir um identificador incremental, nome do veiculo, modelo do veículo, ano do veículo, cor do veículo, categoria e marca. Ex: 1 - Punto - T JET - 2016 - Preto - 2 - 1. 

2 refere-se a CARRO no relacionamento e 1 refere-se a Fiat na Marca.


Como requisitos não funcionais, utilizar banco de dados Mysql.*/