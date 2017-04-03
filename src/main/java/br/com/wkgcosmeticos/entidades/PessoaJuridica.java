package br.com.wkgcosmeticos.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

@Data
@Entity
@PrimaryKeyJoinColumn(name="id")
public class PessoaJuridica extends Pessoa {
	@Column(nullable = false, unique = true, length = 60)
	private String razaoSocial;
	@Column(nullable = false, unique = true, length = 14)
	private String cnpj;
	@Column(nullable = false, unique = true, length = 9)
	private String inscricaoEstadual;
	@Column(nullable = true, unique = true)
	private String inscricaoMunicipal;
	

}
