package com.expertcode.exercicio3.servicos.genericos;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.expertcode.exercicio3.utilitarios.ConversorDtoEntidade;

@Transactional(readOnly = true)
public interface ServicoGenerico<T extends ConversorDtoEntidade<DTO>, DTO, ID> {
	
	@Autowired
	JpaRepository<T, ID> getRepositorio();
	
	@Transactional
	default DTO buscarPorId(ID id) {
		Optional<T> obj = getRepositorio().findById(id);
		return obj.get().converter();
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
		getRepositorio().deleteById(id);
	}
}
