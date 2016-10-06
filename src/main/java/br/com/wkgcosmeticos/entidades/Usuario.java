package br.com.wkgcosmeticos.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Usuario {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable=false, unique=true, length= 10 )
	private String login;
	@Column(nullable=false, length= 20)
	private String senha;
	@JoinColumn
	@ManyToOne
	private Perfil perfil;
}
