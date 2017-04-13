package br.com.wkgcosmeticos.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;

@Data
@Entity
public class Imagem {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    @Transient
    @Lob
    private byte[] arquivo;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private Produto produto;

    private String tipoArquivo;

    public Imagem(String fileName, byte[] arquivo, String tipoArquivo, Produto produto) {
        super();
        this.nome = fileName;
        this.arquivo = arquivo;
        this.tipoArquivo = tipoArquivo;
        this.produto = produto;
    }

    public Imagem() {
        // TODO Auto-generated constructor stub
    }


    @Override
    public String toString() {
        return "Imagem [id=" + id + ", nome=" + nome + ", arquivo=" + Arrays.toString(arquivo) + "]";
    }


}
