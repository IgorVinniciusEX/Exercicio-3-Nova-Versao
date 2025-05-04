package com.expertcode.exercicio3.controladores;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.expertcode.exercicio3.entidades.Categoria;
import com.expertcode.exercicio3.entidades.DTO.CategoriaDTO;
import com.expertcode.exercicio3.servicos.CategoriaServico;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaControlador {

	@Autowired
	private CategoriaServico servico;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Long id){
		CategoriaDTO obj = servico.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> buscarTodos(){
		List<CategoriaDTO> Categorias = servico.buscarTodos();
		return ResponseEntity.ok().body(Categorias);
	}
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> inserir(@RequestBody Categoria obj){
		obj = servico.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
}
