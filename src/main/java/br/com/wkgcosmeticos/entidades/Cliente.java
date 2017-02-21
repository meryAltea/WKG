package br.com.wkgcosmeticos.entidades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Cliente {
	
	@Embedded
	private Endereco endereco;
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false, unique = true, length = 30)
	private String nome;
	@JoinColumn
	@ManyToOne (cascade=CascadeType.ALL)
	private Usuario usuario= new Usuario();
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataNasc;
	@Column(nullable = false, unique = true, length = 11)
	private String cpf;
	@Column(nullable = false, unique = true, length = 9)
	private String rg;
	@Column(nullable = false, length = 10)
	private String tel;
	@Column(nullable = false, length = 11)
	private String cel;
	@Column(nullable = false, length = 20)
	private String email;
//	@Temporal(TemporalType.DATE)
//	@Column(nullable = false)
//	private Date dataCad;
}
