package br.com.wkgcosmeticos.repository;


import java.util.List;

import br.com.wkgcosmeticos.entidades.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImagemRepository extends JpaRepository<Imagem, Integer>{

	Imagem findByNome(String nome);
	
	@Query("select f from Imagem f where f.produto.id=:prodId")
	List<Imagem> buscarPorProdutoId(@Param("prodId") Integer id);

}
