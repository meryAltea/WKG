package br.com.wkgcosmeticos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wkgcosmeticos.entidades.Produto;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto,Integer>{

}
