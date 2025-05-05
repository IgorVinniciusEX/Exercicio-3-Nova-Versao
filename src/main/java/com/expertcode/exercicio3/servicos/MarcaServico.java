package com.expertcode.exercicio3.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expertcode.exercicio3.entidades.Marca;
import com.expertcode.exercicio3.entidades.DTO.MarcaDTO;
import com.expertcode.exercicio3.repositorios.MarcaRepositorio;
import com.expertcode.exercicio3.servicos.excecoes.RecursoNaoEncontradoExcecao;
import com.expertcode.exercicio3.servicos.genericos.ServicoGenerico;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional(readOnly = true)
public class MarcaServico implements ServicoGenerico<Marca, MarcaDTO, Long> {

	@Autowired
	MarcaRepositorio repositorio;

	@Override
	public JpaRepository<Marca, Long> getRepositorio() {
		return repositorio;
	}

	@Transactional
	public Marca atualizar(Long id, Marca obj) {
		try{
			Marca entidade = getRepositorio().getReferenceById(id);
			atualizarDados(entidade, obj);
			return getRepositorio().save(entidade);
		}catch(EntityNotFoundException e){
			throw new RecursoNaoEncontradoExcecao(id);
		}
	}

	public void atualizarDados(Marca entidade, Marca obj) {
		entidade.setNome(obj.getNome());
	}

	public Marca converterDTO(MarcaDTO dto) {
		return new Marca(dto.getId(), dto.getNome());
	}

}
