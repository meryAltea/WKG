package br.com.wkgcosmeticos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wkgcosmeticos.entidades.Pedido;

import br.com.wkgcosmeticos.service.PedidoService;

@RestController
@RequestMapping(value="/admin")
public class PedidoController {
	@Autowired 
	PedidoService pedidoService;
	
	@RequestMapping(value = "/pedidos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Pedido cadastrar(@RequestBody Pedido pedido) {
		return pedidoService.cadastrar(pedido);
	}

	@RequestMapping(value = "/pedidos", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Pedido alterar(@RequestBody Pedido pedido) {
		return pedidoService.alterar(pedido);
	}

	@RequestMapping(value = "/pedidos/{id}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable Integer id) {
		pedidoService.excluir(id);
	}

	@RequestMapping(value = "/pedidos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection <Pedido> buscarTodos() {
		return pedidoService.buscarTodos();
	}

	@RequestMapping(value = "/pedidos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Pedido buscarPorId(@PathVariable Integer id) {
		return pedidoService.buscarPorId(id);
	}
}
