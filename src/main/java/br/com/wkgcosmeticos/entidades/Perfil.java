package br.com.wkgcosmeticos.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Perfil {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false, unique=true, length = 20)
	private String descricao;
}
