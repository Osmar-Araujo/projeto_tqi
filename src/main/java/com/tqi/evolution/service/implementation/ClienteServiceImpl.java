package com.tqi.evolution.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqi.evolution.model.Cliente;
import com.tqi.evolution.repository.ClienteRepository;
import com.tqi.evolution.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public Cliente obterPorCodico(String codigo) {
		return this.repository.findById(codigo).orElseThrow(() -> new IllegalArgumentException("Cliente inexistente!!"));
	}

	@Override
	public Cliente criarCliente(Cliente cliente) { 
		return this.repository.save(cliente);
	}

	@Override
	public List<Cliente> obterTodos() {
		return this.repository.findAll();
	}
	
}
