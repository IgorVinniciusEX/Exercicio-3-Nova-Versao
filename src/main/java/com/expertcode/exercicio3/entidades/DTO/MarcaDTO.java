package com.expertcode.exercicio3.entidades.DTO;

import org.springframework.beans.BeanUtils;

import com.expertcode.exercicio3.entidades.Marca;

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
public class MarcaDTO {
	
	private Long id;
	private String nome;

	public MarcaDTO(Marca entidade) {
		BeanUtils.copyProperties(entidade, this);
	}

}
