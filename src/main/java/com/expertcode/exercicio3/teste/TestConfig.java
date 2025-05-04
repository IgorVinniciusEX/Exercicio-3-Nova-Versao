package com.expertcode.exercicio3.teste;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.expertcode.exercicio3.entidades.Categoria;
import com.expertcode.exercicio3.entidades.Cor;
import com.expertcode.exercicio3.entidades.Marca;
import com.expertcode.exercicio3.entidades.Veiculo;
import com.expertcode.exercicio3.entidades.enumerados.CategoriaEnum;
import com.expertcode.exercicio3.entidades.enumerados.CorEnum;
import com.expertcode.exercicio3.repositorios.CategoriaRepositorio;
import com.expertcode.exercicio3.repositorios.CorRepositorio;
import com.expertcode.exercicio3.repositorios.MarcaRepositorio;
import com.expertcode.exercicio3.repositorios.VeiculoRepositorio;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private VeiculoRepositorio veiculoRepositorio;
	
	@Autowired
	private MarcaRepositorio marcaRepositorio;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	private CorRepositorio corRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		Marca m1 = new Marca(null, "Fiat");
		Marca m2 = new Marca(null, "Audi");
		Marca m3 = new Marca(null, "Triumph");
		Marca m4 = new Marca(null, "Mercedes");
		
		marcaRepositorio.saveAll(Arrays.asList(m1, m2, m3, m4));
		
		Categoria c1 = new Categoria(null, CategoriaEnum.CAMINHAO);
		Categoria c2 = new Categoria(null, CategoriaEnum.CARRO);
		Categoria c3 = new Categoria(null, CategoriaEnum.MOTOCICLETA);
		
		categoriaRepositorio.saveAll(Arrays.asList(c1, c2, c3));
		
		Cor cor1 = new Cor(null, CorEnum.PRATA);
		Cor cor2 = new Cor(null, CorEnum.AMARELO);
		Cor cor3 = new Cor(null, CorEnum.BRANCO);
		Cor cor4 = new Cor(null, CorEnum.CINZA);
		Cor cor5 = new Cor(null, CorEnum.PRETO);
		
		corRepositorio.saveAll(Arrays.asList(cor1, cor2, cor3, cor4, cor5));
		
		Veiculo v1 = new Veiculo(null, "Uno", "ABR2E98", "Mille", 1998, cor1, m1, c2);
		Veiculo v2 = new Veiculo(null, "Palio", "RET-1234", "Weekend", 2007, cor3, m1, c2);
		Veiculo v3 = new Veiculo(null, "A8", "EPO1E34", "Sportback", 2023, cor5, m2, c2);
		Veiculo v4 = new Veiculo(null, "Actros", "VBT-4123", "2548", 2019, cor4, m4, c1);
		Veiculo v5 = new Veiculo(null, "Tiger", "GHJ5Z12", "1200", 2024, cor5, m3, c3);
			
		veiculoRepositorio.saveAll(Arrays.asList(v1, v2, v3, v4, v5));
	}

}
