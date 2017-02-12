package br.com.wkgcosmeticos.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.wkgcosmeticos.entidades.FileUpload;

public interface FileUploadRepository extends JpaRepository<FileUpload, Integer>{

	FileUpload findByFileName(String filename);
	
	@Query("select f from FileUpload f where f.produto.id=:prodId")
	List<FileUpload> buscarPorProdutoId(@Param("prodId") Integer id);

}
