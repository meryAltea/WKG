package br.com.wkgcosmeticos.entidades;

import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Pessoa {
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataNasc;
	@Column(nullable = false, unique = true, length = 30)
	private String nome;
	@Column(nullable = false, unique = true, length = 11)
	private String cpf;
	@Column(nullable = false, unique = true, length = 9)
	private String rg;

}
