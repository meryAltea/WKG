package br.com.wkgcosmeticos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wkgcosmeticos.entidades.PessoaFisica;
import br.com.wkgcosmeticos.entidades.Usuario;

import br.com.wkgcosmeticos.service.PessoaFisicaService;
import br.com.wkgcosmeticos.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController

public class PessoaFisicaController {
	@Autowired
	PessoaFisicaService pessoaFisicaService;

	@RequestMapping(value = "/pessoasFisica", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaFisica cadastrar(@RequestBody PessoaFisica pessoaFisica) {
		return pessoaFisicaService.cadastrar(pessoaFisica);
	}

	@RequestMapping(value = "/pessoasFisica", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaFisica alterar(@RequestBody PessoaFisica pessoaFisica) {
		return pessoaFisicaService.alterar(pessoaFisica);
	}

	@RequestMapping(value = "/pessoasFisica/{id}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable Integer id) {
		pessoaFisicaService.excluir(id);
	}

	@RequestMapping(value = "/pessoasFisica", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection <PessoaFisica> buscarTodos() {
		return pessoaFisicaService.buscarTodos();
	}

	@RequestMapping(value = "/pessoasFisica/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaFisica buscarPorId(@PathVariable Integer id) {
		return pessoaFisicaService.buscarPorId(id);
	}

}
