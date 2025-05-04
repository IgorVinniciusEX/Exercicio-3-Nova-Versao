package com.expertcode.exercicio3.entidades.DTO;

import org.springframework.beans.BeanUtils;

import com.expertcode.exercicio3.entidades.Categoria;
import com.expertcode.exercicio3.entidades.enumerados.CategoriaEnum;

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
public class CategoriaDTO {
	
	private Long id;
	private CategoriaEnum categoriaEnum;
	
	public CategoriaDTO(Categoria entidade) {
		BeanUtils.copyProperties(entidade, this);
	}

}
