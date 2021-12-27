package com.tqi.evolution.service;

import java.util.List;

import com.tqi.evolution.model.Cliente;

public interface ClienteService {
	public List<Cliente> obterTodos();
	public Cliente obterPorCodico(String codigo);
	public Cliente criarCliente (Cliente cliente);
}
