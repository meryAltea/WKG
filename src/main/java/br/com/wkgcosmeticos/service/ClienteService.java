package br.com.wkgcosmeticos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wkgcosmeticos.entidades.Cliente;
import br.com.wkgcosmeticos.entidades.Perfil;
import br.com.wkgcosmeticos.repository.ClienteRepository;
import br.com.wkgcosmeticos.repository.PerfilRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	PerfilRepository perfilRepository;

	public Cliente cadastrar(Cliente cliente) {
		Perfil perfil = perfilRepository.findOne(2);
		cliente.getUsuario().setPerfil(perfil);
		return clienteRepository.save(cliente);
	}

	public Cliente alterar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void excluir(Integer id) {
		clienteRepository.delete(id);
	}

	public Collection<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	public Cliente buscarPorId(Integer id) {
		return clienteRepository.findOne(id);
	}

	public Cliente buscarPorIdUsuario(Integer id) {
		return clienteRepository.buscarPorIdUsuario(id);
	}

//	public Cliente buscarPorCliente(String nome) {
//
//		return clienteRepository.findOne(nome);
//	}
}
