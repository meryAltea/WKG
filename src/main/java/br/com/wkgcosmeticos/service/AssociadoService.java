package br.com.wkgcosmeticos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wkgcosmeticos.entidades.Associado;

import br.com.wkgcosmeticos.repository.AssociadoRepository;
@Service
public class AssociadoService {
	@Autowired
	AssociadoRepository associadoRepository;

	public Associado cadastrar(Associado associado){
		return associadoRepository.save(associado);
	}
	public Associado alterar (Associado atendente){
		return associadoRepository.save(atendente);
	}
	public void excluir (Integer id){
		associadoRepository.delete(id);
	}
	public Collection<Associado> buscarTodos(){
		return associadoRepository.findAll();
	}
	public Associado buscarPorId (Integer id){
		return associadoRepository.findOne(id);
	}
}
