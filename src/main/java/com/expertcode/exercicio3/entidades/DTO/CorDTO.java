package com.expertcode.exercicio3.entidades.DTO;

import org.springframework.beans.BeanUtils;

import com.expertcode.exercicio3.entidades.Cor;
import com.expertcode.exercicio3.entidades.enumerados.CorEnum;

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
public class CorDTO {
	
	private Long id;
	private CorEnum corEnum;
	
	public CorDTO(Cor entidade) {
		BeanUtils.copyProperties(entidade, this);
	}

}
