package br.com.wkgcosmeticos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wkgcosmeticos.entidades.Produto;
import br.com.wkgcosmeticos.service.ProdutoService;


@RestController
public class ProdutoSiteController {
	@Autowired
	ProdutoService produtoService;
	

	@RequestMapping(value="/produtos", method=RequestMethod.GET )
 	public List<Produto> buscarTodosComFotoCapa(){
 	 List <Produto> produtos = produtoService.buscarTodos();
 	 return produtos;
 	}
	

	
}
