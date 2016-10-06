package br.com.wkgcosmeticos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wkgcosmeticos.entidades.Atendente;

import br.com.wkgcosmeticos.service.AtendenteService;

@RestController
public class AtendenteController {
	@Autowired
	AtendenteService atendenteService;

	@RequestMapping(value = "/atendentes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Atendente cadastrar(@RequestBody Atendente atendente) {
		return atendenteService.cadastrar(atendente);
	}

	@RequestMapping(value = "/atendentes", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Atendente alterar(@RequestBody Atendente atendente) {
		return atendenteService.alterar(atendente);
	}

	@RequestMapping(value = "/atendentes/{id}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable Integer id) {
		atendenteService.excluir(id);
	}

	@RequestMapping(value = "/atendentes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Atendente> buscarTodos() {
		return atendenteService.buscarTodos();
	}

	@RequestMapping(value = "/atendentes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Atendente buscarPorId(@PathVariable Integer id) {
		return atendenteService.buscarPorId(id);
	}
}
