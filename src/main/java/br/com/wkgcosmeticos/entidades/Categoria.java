package br.com.wkgcosmeticos.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Categoria {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable=false, length=15)
	private String descricao;
}
