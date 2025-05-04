package com.expertcode.exercicio3.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.expertcode.exercicio3.entidades.DTO.CorDTO;
import com.expertcode.exercicio3.entidades.enumerados.CorEnum;
import com.expertcode.exercicio3.utilitarios.ConversorDtoEntidade;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "tb_cor")
public class Cor implements Serializable, ConversorDtoEntidade<CorDTO> {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String corEnum;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cor")
	private List<Veiculo> veiculos = new ArrayList<>();
	
	public Cor(Long id, CorEnum corEnum) {
		this.id = id;
		setCorEnum(corEnum);
	}
	
	public CorEnum getCorEnum() {
		return CorEnum.pegarEnum(corEnum);
	}

	public void setCorEnum(CorEnum corEnum) {
		this.corEnum = corEnum.getCodigo();
	}

	@Override
	public CorDTO converter() {
		return new CorDTO(this);
	}

}
