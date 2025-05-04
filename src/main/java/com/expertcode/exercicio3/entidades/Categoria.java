package com.expertcode.exercicio3.entidades;

import java.io.Serializable;

import com.expertcode.exercicio3.entidades.DTO.CategoriaDTO;
import com.expertcode.exercicio3.entidades.enumerados.CategoriaEnum;
import com.expertcode.exercicio3.utilitarios.ConversorDtoEntidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_categoria")
public class Categoria implements Serializable, ConversorDtoEntidade<CategoriaDTO> {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String categoriaEnum;
	
	public Categoria(Long id, CategoriaEnum categoriaEnum) {
		this.id = id;
		setCategoriaEnum(categoriaEnum);
	}
	
	public CategoriaEnum getCategoriaEnum() {
		return CategoriaEnum.pegarEnum(categoriaEnum);
	}

	public void setCategoriaEnum(CategoriaEnum categoriaEnum) {
		this.categoriaEnum = categoriaEnum.getCodigo();
	}

	@Override
	public CategoriaDTO converter() {
		return new CategoriaDTO(this);
	}

}
