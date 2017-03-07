package br.com.wkgcosmeticos.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Pessoa implements Serializable {

	@Embedded
	private Endereco endereco;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@JoinColumn
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario usuario = new Usuario();
	@Column(nullable = false, length = 10)
	private String tel;
	@Column(nullable = false, length = 11)
	private String cel;
	@Column(nullable = false, length = 20)
	private String email;

}
