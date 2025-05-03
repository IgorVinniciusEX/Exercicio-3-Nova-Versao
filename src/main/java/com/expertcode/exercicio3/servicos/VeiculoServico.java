package com.expertcode.exercicio3.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expertcode.exercicio3.entidades.Veiculo;
import com.expertcode.exercicio3.entidades.DTO.VeiculoDTO;
import com.expertcode.exercicio3.repositorios.VeiculoRepositorio;
import com.expertcode.exercicio3.servicos.genericos.ServicoGenerico;

@Service
@Transactional(readOnly = true)
public class VeiculoServico implements ServicoGenerico<Veiculo, VeiculoDTO, Long> {
	
	@Autowired
	VeiculoRepositorio repositorio;
	
	@Override
	public JpaRepository<Veiculo, Long> getRepositorio() {
		return repositorio;
	}
	
	@Transactional
	public Veiculo atualizar(Long id, Veiculo obj) {
		Veiculo entidade = getRepositorio().getReferenceById(id);
		atualizarDados(entidade, obj);
		return getRepositorio().save(entidade);
		
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
