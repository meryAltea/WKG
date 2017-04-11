package br.com.wkgcosmeticos.entidades;





import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity

public class Produto {
	@Id
	@GeneratedValue
	
	private Integer id;
	@Column(unique=true)
	private String codigo;
	@Column(unique=true)
	private String nome;
	@JoinColumn @ManyToOne(cascade=CascadeType.ALL)
	private Categoria categoria;
	@Column(nullable=false)
	private String linha;
	@Column
	private String descricao;
	@Column 
	private float preco;
	@Column
	private Integer quantidadeDisponivelParaCompra;
	@Column
	private Integer quantidadeReservada;
//	@NotNull
	@OneToMany (mappedBy="produto")
	private List<FileUpload> fotos;
	private boolean statusNaLoja;
	@OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY, mappedBy= "produto", orphanRemoval= true)
	@JsonIgnore
	private List<ItensPedido> itens;

	
	
		
	
}

