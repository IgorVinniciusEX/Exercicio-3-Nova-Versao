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

import com.expertcode.exercicio3.entidades.Marca;
import com.expertcode.exercicio3.entidades.DTO.MarcaDTO;
import com.expertcode.exercicio3.servicos.MarcaServico;

@RestController
@RequestMapping(value = "/marcas")
public class MarcaControlador {
	
	@Autowired
	MarcaServico servico;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MarcaDTO> buscarPorId(@PathVariable Long id){
		MarcaDTO obj = servico.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<MarcaDTO>> buscarTodos(){
		List<MarcaDTO> Marcas = servico.buscarTodos();
		return ResponseEntity.ok().body(Marcas);
	}
	
	@PostMapping
	public ResponseEntity<MarcaDTO> inserir(@RequestBody Marca obj){
		obj = servico.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Marca> atualizar(@PathVariable Long id, @RequestBody MarcaDTO dto){
		Marca obj = servico.converterDTO(dto);
		obj = servico.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
