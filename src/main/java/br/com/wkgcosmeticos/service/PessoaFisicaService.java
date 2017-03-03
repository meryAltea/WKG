package br.com.wkgcosmeticos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wkgcosmeticos.entidades.Cliente;
import br.com.wkgcosmeticos.entidades.Perfil;
import br.com.wkgcosmeticos.entidades.PessoaFisica;
import br.com.wkgcosmeticos.entidades.PessoaFisica;
import br.com.wkgcosmeticos.repository.PerfilRepository;
import br.com.wkgcosmeticos.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {
	@Autowired
	PessoaFisicaRepository pessoaFisicaRepository;
	@Autowired
	PerfilRepository perfilRepository;

	public PessoaFisica cadastrar(PessoaFisica pessoaFisica) {
		Perfil perfil = perfilRepository.findOne(2);
		pessoaFisica.getUsuario().setPerfil(perfil);
		return pessoaFisicaRepository.save(pessoaFisica);
	}
	public PessoaFisica alterar(PessoaFisica pessoaFisica) {
		return pessoaFisicaRepository.save(pessoaFisica);
	}

	public void excluir(Integer id) {
		pessoaFisicaRepository.delete(id);
	}

	public Collection<PessoaFisica> buscarTodos() {
		return pessoaFisicaRepository.findAll();
	}

	public PessoaFisica buscarPorId(Integer id) {
		return pessoaFisicaRepository.findOne(id);
	}
	public PessoaFisica buscarPorIdUsuario(Integer id) {
		return pessoaFisicaRepository.buscarPorIdUsuario(id);
	}

}
