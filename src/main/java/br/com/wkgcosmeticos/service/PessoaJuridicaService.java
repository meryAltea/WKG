package br.com.wkgcosmeticos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wkgcosmeticos.entidades.Perfil;
import br.com.wkgcosmeticos.entidades.PessoaFisica;
import br.com.wkgcosmeticos.entidades.PessoaJuridica;
import br.com.wkgcosmeticos.repository.PerfilRepository;
import br.com.wkgcosmeticos.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {
	@Autowired
	PessoaJuridicaRepository pessoaJuridicaRepository;
	@Autowired
	PerfilRepository perfilRepository;

	public PessoaJuridica cadastrar(PessoaJuridica pessoaJuridica) {
		Perfil perfil = perfilRepository.findOne(2);
		pessoaJuridica.getUsuario().setPerfil(perfil);
		return pessoaJuridicaRepository.save(pessoaJuridica);
	}

	public PessoaJuridica alterar(PessoaJuridica pessoaJuridica) {
		return pessoaJuridicaRepository.save(pessoaJuridica);
	}

	public void excluir(Integer id) {
		pessoaJuridicaRepository.delete(id);
	}

	public Collection<PessoaJuridica> buscarTodos() {
		return pessoaJuridicaRepository.findAll();
	}

	public PessoaJuridica buscarPorId(Integer id) {
		return pessoaJuridicaRepository.findOne(id);
	}

}
