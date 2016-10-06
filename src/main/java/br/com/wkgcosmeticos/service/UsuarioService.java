package br.com.wkgcosmeticos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wkgcosmeticos.entidades.Usuario;
import br.com.wkgcosmeticos.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario cadastrar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario alterar(Usuario atendente) {
		return usuarioRepository.save(atendente);
	}

	public void excluir(Integer id) {
		usuarioRepository.delete(id);
	}

	public Collection<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarPorId(Integer id) {
		return usuarioRepository.findOne(id);
	}
}
