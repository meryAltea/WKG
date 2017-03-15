package br.com.wkgcosmeticos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wkgcosmeticos.entidades.Pedido;

import br.com.wkgcosmeticos.repository.PedidoRepository;

@Service
public class PedidoService {
@Autowired
PedidoRepository pedidoRepository;

public Pedido cadastrar(Pedido pedido) {
	return pedidoRepository.save(pedido);
}

public Pedido alterar(Pedido pedido) {
	return pedidoRepository.save(pedido);
}

public void excluir(Integer id) {
	pedidoRepository.delete(id);
}

public Collection<Pedido> buscarTodos() {
	return pedidoRepository.findAll();
}

public Pedido buscarPorId(Integer id) {
	return pedidoRepository.findOne(id);
}
}
