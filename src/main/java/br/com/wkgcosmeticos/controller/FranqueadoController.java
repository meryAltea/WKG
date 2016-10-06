package br.com.wkgcosmeticos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wkgcosmeticos.entidades.Franqueado;
import br.com.wkgcosmeticos.service.FranqueadoService;

@RestController
public class FranqueadoController {
	@Autowired
	FranqueadoService franqueadoService;
	@RequestMapping(value="/franqueados", method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
	public Franqueado cadastrar(@RequestBody Franqueado franqueado){
		return franqueadoService.cadastrar(franqueado);
	}
	@RequestMapping(value="/franqueados", method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public Franqueado alterar(@RequestBody Franqueado franqueado){
		return franqueadoService.alterar(franqueado);
	}
	@RequestMapping(value="/franqueados/{id}", method= RequestMethod.DELETE)
	public void excluir(@PathVariable Integer id){
		franqueadoService.excluir(id);
	}
	@RequestMapping(value="/franqueados", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<Franqueado> buscarTodos(){
		return franqueadoService.buscarTodos();
	}
	@RequestMapping(value="/franqueados/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Franqueado buscarPorId(@PathVariable Integer id){
		return franqueadoService.buscarPorId(id);
	}
}
