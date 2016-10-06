package br.com.wkgcosmeticos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.wkgcosmeticos.entidades.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
	@Query("select p from Perfil p order by p.id")
	public List<Perfil> buscarTodos();
}
