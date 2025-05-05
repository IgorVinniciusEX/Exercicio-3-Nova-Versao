package com.expertcode.exercicio3.servicos.genericos;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.print.PrintException;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.expertcode.exercicio3.servicos.excecoes.BancoDeDadosExcecao;
import com.expertcode.exercicio3.servicos.excecoes.RecursoNaoEncontradoExcecao;
import com.expertcode.exercicio3.utilitarios.ConversorDtoEntidade;

public interface ServicoGenerico<T extends ConversorDtoEntidade<DTO>, DTO, ID> {
	
	@Autowired
	JpaRepository<T, ID> getRepositorio();
	
	@Transactional
	default DTO buscarPorId(ID id) {
		Optional<T> obj = getRepositorio().findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoExcecao(id)).converter();
	}
	
	@Transactional
	default List<DTO> buscarTodos(){
		List<T> list = getRepositorio().findAll();
		return list.stream().map(x -> x.converter())
				.collect(Collectors.toList());
	}
	
	@Transactional
	default T inserir(T obj) {
			return getRepositorio().save(obj);
		}
	
	@Transactional
	default void delete(ID id) {
		try{
			if(getRepositorio().existsById(id)){
				getRepositorio().deleteById(id);
			}
			else {
				throw new RecursoNaoEncontradoExcecao(id);
			}
		}catch (DataIntegrityViolationException e){
			throw new BancoDeDadosExcecao("Violação de integridade referencial ao tentar excluir o recurso com id! " + e.getMessage());
		}
	}
}
