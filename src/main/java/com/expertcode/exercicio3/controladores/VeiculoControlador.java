package com.expertcode.exercicio3.controladores;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.expertcode.exercicio3.entidades.Veiculo;
import com.expertcode.exercicio3.entidades.DTO.VeiculoDTO;
import com.expertcode.exercicio3.services.VeiculoServico;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoControlador {
	
	@Autowired
	VeiculoServico servico;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<VeiculoDTO> buscarPorId(@PathVariable Long id){
		VeiculoDTO obj = servico.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<VeiculoDTO>> buscarTodos(){
		List<VeiculoDTO> veiculos = servico.buscarTodos();
		return ResponseEntity.ok().body(veiculos);
	}
	
	@PostMapping
	public ResponseEntity<VeiculoDTO> inserir(@RequestBody Veiculo obj){
		obj = servico.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody VeiculoDTO dto){
		Veiculo obj = servico.converterDTO(dto);
		obj = servico.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
