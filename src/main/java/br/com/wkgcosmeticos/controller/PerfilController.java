package br.com.wkgcosmeticos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wkgcosmeticos.entidades.Perfil;
import br.com.wkgcosmeticos.entidades.Usuario;
import br.com.wkgcosmeticos.repository.PerfilRepository;
import br.com.wkgcosmeticos.service.PerfilService;

@RestController
public class PerfilController {
	@Autowired
	PerfilService perfilService;

	@RequestMapping(value = "/perfis", method = RequestMethod.POST)
	public Perfil inserir(@RequestBody Perfil perfil) {
		return perfilService.cadastrar(perfil);
	}

	@RequestMapping(value = "/perfis", method = RequestMethod.PUT)
	public Perfil alterar(@RequestBody Perfil perfil) {
		return perfilService.cadastrar(perfil);
	}

	@RequestMapping(value = "/perfis/{id}", method = RequestMethod.GET)
	public Perfil buscarPorId(@PathVariable("id") Integer id) {
		return perfilService.buscarPorId(id);
	}

	@RequestMapping(value = "/perfis", method = RequestMethod.GET)
	public Collection<Perfil> buscarTodos() {
		return perfilService.buscarTodos();
	}

	@RequestMapping(value = "/perfis/{id}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable("id") Integer id) {
		perfilService.excluir(id);
	}
}
