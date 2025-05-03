package com.expertcode.exercicio3.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expertcode.exercicio3.entidades.Veiculo;
import com.expertcode.exercicio3.services.VeiculoServico;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoControlador {
	
	@Autowired
	VeiculoServico servico;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id){
		Veiculo obj = servico.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> buscarTodos(){
		List<Veiculo> list = servico.buscarTodos();
		return ResponseEntity.ok().body(list);
	}

}
