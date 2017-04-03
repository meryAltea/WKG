package br.com.wkgcosmeticos.entidades;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity
public class Pedido implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
    @JoinColumn(name="pessoa_id")
    private Pessoa pessoa;
	@ManyToMany( fetch = FetchType.EAGER)
    @JoinColumn(name="produto_id")
	private List<Produto> produtos;
	private String data=converterData();
	private String status;
	@Embedded
	private Endereco enderecoDeEntrega;

//private String tipoDePagamento;

	private String converterData(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		String resultado="";
		//			data = sdf.parse("27/07/2006");
		 resultado= sdf.format(data);
		
		return resultado;
	}
	
}
