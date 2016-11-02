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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Atendente {
	
	@Embedded
	private Endereco endereco;
	@Id
	@GeneratedValue
	private Integer idAtend;
	@Column(nullable = false, unique = true, length = 30)
	private String nomeAtend;
	@JoinColumn
	@ManyToOne (cascade=CascadeType.ALL)
	private Usuario usuario= new Usuario();
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataNascAtend;
	@Column(nullable = false, unique = true, length = 11)
	private String cpfAtend;
	@Column(nullable = false, unique = true, length = 9)
	private String rgAtend;
	@Column(nullable = false, length = 10)
	private String telAtend;
	@Column(nullable = false, length = 11)
	private String celAtend;
	@Column(nullable = false, length = 20)
	private String emailAtend;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataCadAtend;
}
