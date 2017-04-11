package br.com.wkgcosmeticos.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class ItensPedido implements Serializable{
	@Id
	@ManyToOne
	private Produto produto;
	@Id
	@ManyToOne
	@JsonIgnore
	private Pedido pedido;
	private Integer quantidade;
	
	public ItensPedido() {
		
	}

	public ItensPedido(Produto produto, Pedido pedido, Integer quantidade) {
		
		this.produto = produto;
		this.pedido = pedido;
		this.quantidade = quantidade;
	}
}
