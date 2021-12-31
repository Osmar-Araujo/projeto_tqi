package com.tqi.evolution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tqi.evolution.model.Cliente;
import com.tqi.evolution.model.dto.UsuarioDto;
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
	public UsuarioDto obterUsuario(@PathVariable String codigo) {
		Cliente cliente = this.service.obterUsuario(codigo);
		return toUsuarioDto(cliente);
	}

	@PostMapping
	public Cliente criarCliente(@RequestBody Cliente cliente) {
		cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
		return this.service.criarCliente(cliente);
	}
	
	public UsuarioDto toUsuarioDto(Cliente cliente) {
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setUserEmail(cliente.getEmail());
		usuarioDto.setSenha(cliente.getSenha());
		return usuarioDto;
	}
}
