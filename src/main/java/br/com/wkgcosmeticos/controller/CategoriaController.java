package br.com.wkgcosmeticos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wkgcosmeticos.entidades.Categoria;
import br.com.wkgcosmeticos.service.CategoriaService;

@RestController
@RequestMapping(value="/admin")
public class CategoriaController {
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping(value="/categorias", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
 	public Categoria inserir(@RequestBody Categoria categoria){
 		return categoriaService.cadastrar(categoria);
 	}
 	@RequestMapping(value="/categorias", method=RequestMethod.PUT)
 	public Categoria alterar(@RequestBody Categoria categoria){
 		return categoriaService.cadastrar(categoria);
 	}
 	@RequestMapping(value="/categorias{id}", method=RequestMethod.GET )
 	public Categoria buscarPorId(@PathVariable("id") Integer id){
 		return categoriaService.buscarPorId(id);
 	}
 	@RequestMapping(value="/categorias", method=RequestMethod.GET )
 	public Collection<Categoria> buscarTodos(){
 		return categoriaService.buscarTodos();
 	}
	@RequestMapping(value = "/categorias/{id}", method= RequestMethod.DELETE)
	public void excluir(@PathVariable Integer id){
		categoriaService.excluir(id);
	}
}
