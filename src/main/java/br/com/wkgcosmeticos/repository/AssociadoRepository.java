package br.com.wkgcosmeticos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wkgcosmeticos.entidades.Associado;
@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Integer>{

}
