package br.com.wkgcosmeticos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wkgcosmeticos.entidades.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	@Query("select p from Pessoa p where p.usuario.id=:usuarioid")
	Pessoa buscarPorIdUsuario(@Param("usuarioid") Integer id);
}

