package br.com.wkgcosmeticos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItensPedido {
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	@JoinColumn
	private Produto produtos;
	@ManyToOne
	@JoinColumn
	private Pedido pedido;
	private Integer quantidade;
}
