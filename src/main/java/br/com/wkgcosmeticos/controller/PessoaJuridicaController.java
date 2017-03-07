package br.com.wkgcosmeticos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wkgcosmeticos.entidades.PessoaJuridica;
import br.com.wkgcosmeticos.service.PessoaJuridicaService;
@RestController

public class PessoaJuridicaController {
	@Autowired
	PessoaJuridicaService pessoaJuridicaService;
	
	@RequestMapping(value = "/pessoasJuridica", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaJuridica cadastrar(@RequestBody PessoaJuridica pessoaJuridica) {
		return pessoaJuridicaService.cadastrar(pessoaJuridica);
	}

	@RequestMapping(value = "/pessoasJuridica", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaJuridica alterar(@RequestBody PessoaJuridica pessoaJuridica) {
		return pessoaJuridicaService.alterar(pessoaJuridica);
	}

	@RequestMapping(value = "/pessoasJuridica/{id}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable Integer id) {
		pessoaJuridicaService.excluir(id);
	}

	@RequestMapping(value = "/pessoasJuridica", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection <PessoaJuridica> buscarTodos() {
		return pessoaJuridicaService.buscarTodos();
	}

	@RequestMapping(value = "/pessoasJuridica/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaJuridica buscarPorId(@PathVariable Integer id) {
		return pessoaJuridicaService.buscarPorId(id);
	}

}
