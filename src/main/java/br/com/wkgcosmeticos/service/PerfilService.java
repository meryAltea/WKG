package br.com.wkgcosmeticos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wkgcosmeticos.entidades.Perfil;
import br.com.wkgcosmeticos.repository.PerfilRepository;

@Service
public class PerfilService {
	@Autowired
	PerfilRepository perfilRepository;
	public Perfil cadastrar(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	public Perfil alterar(Perfil atendente) {
		return perfilRepository.save(atendente);
	}

	public void excluir(Integer id) {
		perfilRepository.delete(id);
	}

	public Collection<Perfil> buscarTodos() {
		return perfilRepository.findAll();
	}

	public Perfil buscarPorId(Integer id) {
		return perfilRepository.findOne(id);
	}
}
