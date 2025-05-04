package com.expertcode.exercicio3.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expertcode.exercicio3.entidades.Categoria;
import com.expertcode.exercicio3.entidades.DTO.CategoriaDTO;
import com.expertcode.exercicio3.repositorios.CategoriaRepositorio;
import com.expertcode.exercicio3.servicos.genericos.ServicoGenerico;

@Service
@Transactional(readOnly = true)
public class CategoriaServico implements ServicoGenerico<Categoria, CategoriaDTO, Long>{
	
	@Autowired
	CategoriaRepositorio repositorio;

	@Override
	public JpaRepository<Categoria, Long> getRepositorio() {
		return repositorio;
	}

}
