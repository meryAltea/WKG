package br.com.wkgcosmeticos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import br.com.wkgcosmeticos.entidades.PessoaFisica;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Integer> {
	@Query("select p from PessoaFisica p where p.usuario.id=:usuarioid")
	PessoaFisica buscarPorIdUsuario(@Param("usuarioid") Integer id);
}
