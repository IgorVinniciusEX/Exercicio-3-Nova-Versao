package com.expertcode.exercicio3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertcode.exercicio3.entidades.Veiculo;
import com.expertcode.exercicio3.repositorios.VeiculoRepositorio;

@Service
public class VeiculoServico {
	
	@Autowired
	VeiculoRepositorio repositorio;
	
	public Veiculo buscarPorId(Long id) {
		return repositorio.findById(id).get();
	}
	
	public List<Veiculo> buscarTodos(){
		return repositorio.findAll();
	}
	
}
