package br.com.wkgcosmeticos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wkgcosmeticos.entidades.Pessoa;
import br.com.wkgcosmeticos.entidades.Usuario;
import br.com.wkgcosmeticos.service.PessoaService;
import br.com.wkgcosmeticos.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
public class PessoaController {
	@Autowired
	PessoaService pessoaService;
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "/pessoas/{id}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable Integer id) {
		pessoaService.excluir(id);
	}
	
	@RequestMapping(value = "/pessoas/{id}", method = RequestMethod.GET)
	public Pessoa buscarPorId(@PathVariable("id") Integer id) {
		return pessoaService.buscarPorId(id);
	}

	@RequestMapping(value = "/pessoas", method = RequestMethod.GET)
	public Collection<Pessoa> buscarTodos() {
		return pessoaService.buscarTodos();
	}
	@RequestMapping(value = "/buscarPessoas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Pessoa buscarPorPessoa(@RequestHeader(value="token") String token){
		
		Claims claims=Jwts.parser().setSigningKey("banana").parseClaimsJws(token).getBody();
		Usuario usuario= usuarioService.buscarPorUsername(claims.getSubject());
		return pessoaService.buscarPorIdUsuario(usuario.getId());
		
	}
}
