package br.com.wkgcosmeticos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wkgcosmeticos.entidades.Associado;
import br.com.wkgcosmeticos.service.AssociadoService;

@RestController
@RequestMapping(value="/admin")
public class AssociadoController {
	@Autowired
	AssociadoService associadoService;

	@RequestMapping(value = "/associados", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Associado cadastrar(@RequestBody Associado associado) {
		return associadoService.cadastrar(associado);
	}

	@RequestMapping(value = "/associados", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Associado aalterar(@RequestBody Associado associado) {
		return associadoService.alterar(associado);
	}

	@RequestMapping(value = "/associados/{id}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable Integer id) {
		associadoService.excluir(id);
	}

	@RequestMapping(value = "/associados", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Associado> buscarTodos() {
		return associadoService.buscarTodos();
	}

	@RequestMapping(value = "/associados/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Associado buscarPorId(@PathVariable Integer id) {
		return associadoService.buscarPorId(id);
	}
}
