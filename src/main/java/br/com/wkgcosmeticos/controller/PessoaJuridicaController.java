package br.com.wkgcosmeticos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import br.com.wkgcosmeticos.entidades.PessoaJuridica;
import br.com.wkgcosmeticos.entidades.Usuario;

import br.com.wkgcosmeticos.service.PessoaJuridicaService;
import br.com.wkgcosmeticos.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class PessoaJuridicaController {
	@Autowired
	PessoaJuridicaService pessoaJuridicaService;
	@Autowired
	UsuarioService usuarioService;
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
	@RequestMapping(value = "/pessoasJuridica/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public PessoaJuridica buscarPorPessoaFisica(@RequestHeader(value="token") String token){
		
		Claims claims=Jwts.parser().setSigningKey("banana").parseClaimsJws(token).getBody();
		Usuario usuario= usuarioService.buscarPorUsername(claims.getSubject());
		return pessoaJuridicaService.buscarPorIdUsuario(usuario.getId());
		
	}
}
