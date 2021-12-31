package com.tqi.evolution.service;

import java.util.List;

import com.tqi.evolution.model.Cliente;
import com.tqi.evolution.model.dto.UsuarioDto;

public interface ClienteService {
	public List<Cliente> obterTodos();
	public Cliente obterUsuario(String codigo);
	public Cliente criarCliente (Cliente cliente);
	public UsuarioDto obterUsuarioDto(String userEmail);
}
