package com.expertcode.exercicio3.teste;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.expertcode.exercicio3.entidades.Veiculo;
import com.expertcode.exercicio3.repositorios.VeiculoRepositorio;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	VeiculoRepositorio veiculoRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		Veiculo v1 = new Veiculo(null, "Uno", "VBT-4123", "Mille", 1998);
		Veiculo v2 = new Veiculo(null, "Fiesta", "RET-1234", "GT", 2007);
		
		veiculoRepositorio.saveAll(Arrays.asList(v1, v2));
	}

}
