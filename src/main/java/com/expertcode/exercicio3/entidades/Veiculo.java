package com.expertcode.exercicio3.entidades;

import java.io.Serializable;

import com.expertcode.exercicio3.entidades.DTO.VeiculoDTO;
import com.expertcode.exercicio3.utilitarios.ConversorDtoEntidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable, ConversorDtoEntidade<VeiculoDTO>{
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String placa;
	private String modelo;
	private Integer anoVeiculo;
	
	@Override
	public VeiculoDTO converter() {
		return new VeiculoDTO(this);
	}
	
}
