package br.com.wkgcosmeticos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wkgcosmeticos.entidades.Cliente;

import br.com.wkgcosmeticos.service.ClienteService;

@RestController
public class ClienteController {
	@Autowired
	ClienteService clienteService;

	@RequestMapping(value = "/clientes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente cadastrar(@RequestBody Cliente cliente) {
		return clienteService.cadastrar(cliente);
	}

	@RequestMapping(value = "/clientes", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente alterar(@RequestBody Cliente cliente) {
		return clienteService.alterar(cliente);
	}

	@RequestMapping(value = "/clientes/{id}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable Integer id) {
		clienteService.excluir(id);
	}

	@RequestMapping(value = "/clientes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Cliente> buscarTodos() {
		return clienteService.buscarTodos();
	}

	@RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente buscarPorId(@PathVariable Integer id) {
		return clienteService.buscarPorId(id);
	}
}
