package br.com.wkgcosmeticos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wkgcosmeticos.entidades.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	@Query(value="select c from Cliente c where c.usuario=:usuarioid")
	Cliente buscarPorIdUsuario(@Param("usuarioid") Integer id);


}
