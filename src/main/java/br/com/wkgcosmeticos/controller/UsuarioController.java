package br.com.wkgcosmeticos.controller;


import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wkgcosmeticos.entidades.Usuario;
import br.com.wkgcosmeticos.repository.UsuarioRepository;
import br.com.wkgcosmeticos.service.UsuarioService;

@RestController
@RequestMapping(value="/admin")
public class UsuarioController {
 @Autowired
 UsuarioService usuarioService;
 	@RequestMapping(value="/usuarios", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
 	public Usuario inserir(@RequestBody Usuario usuario){
 		return usuarioService.cadastrar(usuario);
 	}
 	@RequestMapping(value="/usuarios", method=RequestMethod.PUT)
 	public Usuario alterar(@RequestBody Usuario usuario){
 		return usuarioService.cadastrar(usuario);
 	}
 	@RequestMapping(value="/usuarios{id}", method=RequestMethod.GET )
 	public Usuario buscarPorId(@PathVariable("id") Integer id){
 		return usuarioService.buscarPorId(id);
 	}
 	@RequestMapping(value="/usuarios", method=RequestMethod.GET )
 	public Collection<Usuario> buscarTodos(){
 		return usuarioService.buscarTodos();
 	}
	@RequestMapping(value = "/usuarios/{id}", method= RequestMethod.DELETE)
	public void excluir(@PathVariable Integer id){
		usuarioService.excluir(id);
	}
}
