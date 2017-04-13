package br.com.wkgcosmeticos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wkgcosmeticos.entidades.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	@Query("select distinct p from Produto p left join fetch p.fotos")
	public List<Produto> buscarTodos();

	@Query("select new Produto(id, nome, descricao) from Produto p where p.id=:id " )
	Produto buscarPorId(@Param("id") Integer id);
}
