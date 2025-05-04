package com.expertcode.exercicio3.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expertcode.exercicio3.entidades.DTO.CorDTO;
import com.expertcode.exercicio3.servicos.CorServico;

@RestController
@RequestMapping(value = "/cores")
public class CorControlador {

	@Autowired
	private CorServico servico;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CorDTO> buscarPorId(@PathVariable Long id){
		CorDTO obj = servico.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<CorDTO>> buscarTodos(){
		List<CorDTO> Cors = servico.buscarTodos();
		return ResponseEntity.ok().body(Cors);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
}
