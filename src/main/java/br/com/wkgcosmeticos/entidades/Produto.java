package br.com.wkgcosmeticos.entidades;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class Produto {
	@Id
	@GeneratedValue
	
	private Integer idProd;
	@Column(nullable=false, unique=true, length=6)
	private String codProd;
	@Column(nullable=false, unique=true, length=15)
	private String nomeProd;
	@Column(nullable=false, length=15)
	private String catProd;
	@Column(nullable=false, length=15)
	private String linhaProd;
	@Column(nullable=false, length=250)
	private String descricaoProd;
	@Column(nullable=false, length=6)
	private Float precoProd;
	private Blob fotoProd;

}
