package br.com.wkgcosmeticos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wkgcosmeticos.entidades.Pessoa;
import br.com.wkgcosmeticos.entidades.PessoaFisica;
import br.com.wkgcosmeticos.repository.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
	PessoaRepository pessoaRepository;

	public Pessoa buscarPorId(Integer id) {
		return pessoaRepository.findOne(id);
	}
	public Collection<Pessoa> buscarTodos() {
		return pessoaRepository.findAll();
	}
	
	public Pessoa buscarPorIdUsuario(Integer id) {
	return pessoaRepository.buscarPorIdUsuario(id);
		}
	public void excluir(Integer id) {
		pessoaRepository.delete(id);
	}
	
}
