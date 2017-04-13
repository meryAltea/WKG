package br.com.wkgcosmeticos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wkgcosmeticos.entidades.Produto;
import br.com.wkgcosmeticos.repository.ImagemRepository;
import br.com.wkgcosmeticos.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	ImagemRepository fileUploadRepository;

	public Produto cadastrar(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto alterar(Produto atendente) {
		return produtoRepository.save(atendente);
	}

	public void excluir(Integer id) {
		produtoRepository.delete(id);
	}

	public List <Produto> buscarTodos() {
		return produtoRepository.buscarTodos();
	}
//	public List <Produto> buscarTodos() {
//		 List<Produto> produtos = produtoRepository.findAll();
//		 for(Produto p: produtos){
//			List<Imagem> fotos= fileUploadRepository.buscarPorProdutoId(p.getId());
//			p.setFotos(fotos);
//		 }
//		 return produtos;
//	}

//	public Collection<Produto> buscarTodosComFotoCapa() {
//		 List<Produto> produtos = produtoRepository.findAll();
//		 for(Produto p:produtos){
//			 Imagem fileUpload = fileUploadRepository.buscarCapaPorProdutoId(p.getId()).get(0);
//			 p.adicionarFoto(fileUpload);
//			 
//		 }
//		 return produtos;
//	}
	

	public Produto buscarPorId(Integer id) {
		return produtoRepository.buscarPorId(id);
	}
}
