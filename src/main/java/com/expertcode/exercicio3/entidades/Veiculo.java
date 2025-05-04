package com.expertcode.exercicio3.entidades;

import java.io.Serializable;

import com.expertcode.exercicio3.entidades.DTO.VeiculoDTO;
import com.expertcode.exercicio3.utilitarios.ConversorDtoEntidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@NoArgsConstructor
@AllArgsConstructor
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
	
	@ManyToOne
	@JoinColumn(name = "cor_id")
	private Cor cor;
	
	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@Override
	public VeiculoDTO converter() {
		return new VeiculoDTO(this);
	}
}
