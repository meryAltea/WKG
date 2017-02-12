package br.com.wkgcosmeticos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wkgcosmeticos.entidades.Categoria;
import br.com.wkgcosmeticos.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria cadastrar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public Categoria alterar(Categoria atendente) {
		return categoriaRepository.save(atendente);
	}

	public void excluir(Integer id) {
		categoriaRepository.delete(id);
	}

	public Collection<Categoria> buscarTodos() {
		return categoriaRepository.findAll();
	}

	public Categoria buscarPorId(Integer id) {
		return categoriaRepository.findOne(id);
	}
}
