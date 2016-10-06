package br.com.wkgcosmeticos.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Associado {
	@Id
	@GeneratedValue
	private Integer idAssc;
	@Column(nullable = false, unique = true, length = 30)
	private String nomeAssc;
	@Column(nullable = false, unique = true, length = 20)
	private String emailAssc;
}
