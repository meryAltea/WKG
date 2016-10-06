package br.com.wkgcosmeticos.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wkgcosmeticos.entidades.Franqueado;
import br.com.wkgcosmeticos.repository.FranqueadoRepository;
@Service
public class FranqueadoService {
	@Autowired
	FranqueadoRepository franqueadoRepository;

	public Franqueado cadastrar(Franqueado franqueado) {
		return franqueadoRepository.save(franqueado);
	}
	public Franqueado alterar (Franqueado franqueado){
		return franqueadoRepository.save(franqueado);
	}
	public void excluir(Integer id){
		franqueadoRepository.delete(id);
	}
	public Collection<Franqueado> buscarTodos(){
		return franqueadoRepository.findAll();
	}
	public Franqueado buscarPorId(Integer id){
		return franqueadoRepository.findOne(id);
	}
	
}
