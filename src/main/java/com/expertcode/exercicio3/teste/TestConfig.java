package com.expertcode.exercicio3.teste;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.expertcode.exercicio3.entidades.Marca;
import com.expertcode.exercicio3.entidades.Veiculo;
import com.expertcode.exercicio3.repositorios.MarcaRepositorio;
import com.expertcode.exercicio3.repositorios.VeiculoRepositorio;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	VeiculoRepositorio veiculoRepositorio;
	
	@Autowired
	MarcaRepositorio marcaRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		Veiculo v1 = new Veiculo(null, "Uno", "VBT-4123", "Mille", 1998);
		Veiculo v2 = new Veiculo(null, "Fiesta", "RET-1234", "GT", 2007);
		
		veiculoRepositorio.saveAll(Arrays.asList(v1, v2));
		
		Marca m1 = new Marca(null, "Fiat");
		Marca m2 = new Marca(null, "Audi");
		Marca m3 = new Marca(null, "Triumph");
		Marca m4 = new Marca(null, "Mercedes");
		
		marcaRepositorio.saveAll(Arrays.asList(m1, m2, m3, m4));
	}

}
