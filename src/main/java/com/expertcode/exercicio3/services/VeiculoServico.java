package com.expertcode.exercicio3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expertcode.exercicio3.entidades.Veiculo;
import com.expertcode.exercicio3.entidades.DTO.VeiculoDTO;
import com.expertcode.exercicio3.repositorios.VeiculoRepositorio;

@Service
@Transactional(readOnly = true)
public class VeiculoServico {
	
	@Autowired
	VeiculoRepositorio repositorio;
	
	@Transactional
	public Veiculo buscarPorId(Long id) {
		Optional<Veiculo> obj = repositorio.findById(id);
		return obj.get();
	}
	
	@Transactional
	public List<Veiculo> buscarTodos(){
		return repositorio.findAll();
	}
	
	@Transactional
	public Veiculo inserir(Veiculo obj) {
		return repositorio.save(obj);
	}
	
	@Transactional
	public void delete(Long id) {
		repositorio.deleteById(id);
	}
	
	@Transactional
	public Veiculo atualizar(Long id, Veiculo obj) {
		Veiculo entidade = repositorio.getReferenceById(id);
		atualizarDados(entidade, obj);
		return repositorio.save(entidade);
		
	}
	
	public void atualizarDados(Veiculo entidade, Veiculo obj) {
		entidade.setNome(obj.getNome());
		entidade.setPlaca(obj.getPlaca());
		entidade.setAnoVeiculo(obj.getAnoVeiculo());
		entidade.setModelo(obj.getModelo());
	}
	
	public Veiculo converterDTO(VeiculoDTO dto) {
		return new Veiculo(dto.getId(), dto.getNome(), dto.getPlaca(), dto.getModelo(),
				dto.getAnoVeiculo());
	}
}
