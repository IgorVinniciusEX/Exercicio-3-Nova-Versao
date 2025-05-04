package com.expertcode.exercicio3.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expertcode.exercicio3.entidades.Cor;
import com.expertcode.exercicio3.entidades.DTO.CorDTO;
import com.expertcode.exercicio3.repositorios.CorRepositorio;
import com.expertcode.exercicio3.servicos.genericos.ServicoGenerico;

@Service
@Transactional(readOnly = true)
public class CorServico implements ServicoGenerico<Cor, CorDTO, Long>{
	
	@Autowired
	CorRepositorio repositorio;

	@Override
	public JpaRepository<Cor, Long> getRepositorio() {
		return repositorio;
	}

}
