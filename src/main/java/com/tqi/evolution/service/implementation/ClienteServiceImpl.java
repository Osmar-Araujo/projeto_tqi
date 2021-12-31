package com.tqi.evolution.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqi.evolution.model.Cliente;
import com.tqi.evolution.model.dto.UsuarioDto;
import com.tqi.evolution.repository.ClienteRepository;
import com.tqi.evolution.service.ClienteService;


@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public Cliente obterUsuario(String codigo) {
		return this.repository.findById(codigo).orElseThrow(() -> new IllegalArgumentException("Usuario inexistente!!"));
	}

	@Override
	public Cliente criarCliente(Cliente cliente) { 
		return this.repository.save(cliente);
	}

	@Override
	public List<Cliente> obterTodos() {
		return this.repository.findAll();
	}

	@Override
	public UsuarioDto obterUsuarioDto(String userEmail) {
		Cliente cliente = this.repository.findByEmail(userEmail);
		return toUsuarioDto(cliente);
	}
	
	public UsuarioDto toUsuarioDto(Cliente cliente) {
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setUserEmail(cliente.getEmail());
		usuarioDto.setSenha(cliente.getSenha());
		return usuarioDto;
	}
	
}
