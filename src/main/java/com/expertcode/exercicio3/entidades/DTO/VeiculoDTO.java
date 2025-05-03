package com.expertcode.exercicio3.entidades.DTO;

import org.springframework.beans.BeanUtils;

import com.expertcode.exercicio3.entidades.Veiculo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {
	
	private Long id;
	private String nome;
	private String placa;
	private String modelo;
	private Integer anoVeiculo;
	
	public VeiculoDTO(Veiculo entidade) {
		BeanUtils.copyProperties(entidade, this);
	}

}
