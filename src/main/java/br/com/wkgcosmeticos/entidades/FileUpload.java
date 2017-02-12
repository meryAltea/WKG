package br.com.wkgcosmeticos.entidades;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class FileUpload {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String fileName;

	@Lob
	private byte[] file;
	@JoinColumn @ManyToOne @JsonIgnore
	private Produto produto;
	private String mimeType;

	public FileUpload(String fileName, byte[] file, String mimeType, Produto produto) {
		super();
		this.fileName = fileName;
		this.file = file;
		this.mimeType = mimeType;
		this.produto= produto;
	}
	
	public FileUpload() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileUpload other = (FileUpload) obj;
		if (!Arrays.equals(file, other.file))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(file);
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "FileUpload [id=" + id + ", fileName=" + fileName + ", file=" + Arrays.toString(file) + "]";
	}
	

	
	
}
