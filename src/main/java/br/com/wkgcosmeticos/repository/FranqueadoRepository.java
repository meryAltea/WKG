package br.com.wkgcosmeticos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wkgcosmeticos.entidades.Franqueado;
@Repository
public interface FranqueadoRepository extends JpaRepository<Franqueado, Integer>{

}
