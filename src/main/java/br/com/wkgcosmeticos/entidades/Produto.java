package br.com.wkgcosmeticos.entidades;





import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
//	@NotNull
	@OneToMany (mappedBy="produto")
	private List<FileUpload> fotos;
//	@Column(nullable=false)
//	BigDecimal p = new BigDecimal("1220.00");
//	NumberFormat nf= NumberFormat.getCurrencyInstance();
//	String s= nf.format(p);
//	
//	public void adicionarFoto(FileUpload fileUpload) {
//		if(fotos==null){
//			fotos=new ArrayList<>();
//		}
//		fotos.add(fileUpload);
//		
//	}

	
	
		
	
}

