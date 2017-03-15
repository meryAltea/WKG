package br.com.wkgcosmeticos.entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

import java.io.Serializable;
@Data
@Embeddable

public class Endereco implements Serializable{
	@Column(nullable = false, length = 20)
	private String pais;
	@Column(nullable = false, length = 50)
	private String rua;
	@Column(nullable = false, length = 5)
	private Integer numero;
	@Column(nullable = false, length = 15)
	private String cidade;
	@Column(nullable = false, length = 15)
	private String bairro;
	@Column(nullable = false, length = 2)
	private String uf;
	@Column(nullable = false, length = 8)
	private Integer cep;

}
