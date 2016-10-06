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

import lombok.Data;

@Data
@Entity
public class Franqueado {
	@Id
	@GeneratedValue
	private Integer idFrq;
	@Embedded
	private Endereco endereco;
	@JoinColumn
	@ManyToOne(cascade=CascadeType.ALL)
	private Usuario usuario = new Usuario();
	@Column(nullable=false, unique=true, length=30)
	private String nomeFrq;
	@Column(nullable=false, length=8)
	private Date dataNascFrq;
	@Column(nullable=false, unique=true, length=14)
	private String cnpjFrq;
	@Column(nullable=false,length=10)
	private String telFrq;
	@Column(nullable=false, length=11)
	private String celFrq;
	@Column(nullable=false, length=20)
	private String emailFrq;
	@Column(nullable=false, length=8)
	private Date dataCadFrq;
	

}
