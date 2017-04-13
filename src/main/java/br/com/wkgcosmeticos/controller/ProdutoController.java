package br.com.wkgcosmeticos.controller;

import br.com.wkgcosmeticos.entidades.Categoria;
import br.com.wkgcosmeticos.entidades.Produto;
import br.com.wkgcosmeticos.service.CategoriaService;
import br.com.wkgcosmeticos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;
    @Autowired
    CategoriaService categoriaService;

    @RequestMapping(value = "/produtos", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Produto inserir(@RequestBody Produto produto) {
        Categoria categoria = categoriaService.buscarPorId(produto.getCategoria().getId());
        produto.setCategoria(categoria);
        return produtoService.cadastrar(produto);

    }

    @RequestMapping(value = "/produtos", method = RequestMethod.PUT)
    public Produto alterar(@RequestBody Produto produto) {
        return produtoService.cadastrar(produto);
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
    public Produto buscarPorId(@PathVariable("id") Integer id) {
        return produtoService.buscarPorId(id);
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public List<Produto> buscarTodos() {
        return produtoService.buscarTodos();
    }


    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
    public void excluir(@PathVariable Integer id) {
        produtoService.excluir(id);
    }
}
