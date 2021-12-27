package com.tqi.evolution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tqi.evolution.model.Cliente;
import com.tqi.evolution.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public List<Cliente> obterTodos(){
		return this.service.obterTodos();
	}

	@GetMapping("/{codigo}")
	public Cliente obterPorCodico(@PathVariable String codigo) {
		return this.service.obterPorCodico(codigo);
	}

	@PostMapping
	public Cliente criarCliente(@RequestBody Cliente cliente) {
		return this.service.criarCliente(cliente);
	}
}
