package br.com.wkgcosmeticos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.wkgcosmeticos.entidades.Categoria;
import br.com.wkgcosmeticos.entidades.Produto;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	@Query("select p from Produto p order by p.id")
	public List<Produto> buscarTodos();
}
