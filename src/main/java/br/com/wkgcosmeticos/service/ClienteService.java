package br.com.wkgcosmeticos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wkgcosmeticos.entidades.Atendente;
import br.com.wkgcosmeticos.entidades.Perfil;
import br.com.wkgcosmeticos.repository.AtendenteRepository;
import br.com.wkgcosmeticos.repository.PerfilRepository;

@Service
public class AtendenteService {
	@Autowired
	AtendenteRepository atendenteRepository;
	@Autowired
	PerfilRepository perfilRepository;

	public Atendente cadastrar(Atendente atendente) {
		Perfil perfil= perfilRepository.findOne(2); 
		atendente.getUsuario().setPerfil(perfil);
		return atendenteRepository.save(atendente);
	}

	public Atendente alterar(Atendente atendente) {
		return atendenteRepository.save(atendente);
	}

	public void excluir(Integer id) {
		atendenteRepository.delete(id);
	}

	public Collection<Atendente> buscarTodos() {
		return atendenteRepository.findAll();
	}

	public Atendente buscarPorId(Integer id) {
		return atendenteRepository.findOne(id);
	}
}