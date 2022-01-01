package com.tqi.evolution.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.tqi.evolution.model.dto.UsuarioDto;
import com.tqi.evolution.service.implementation.ClienteServiceImpl;

@Repository
public class ImplementUserDetailService implements UserDetailsService{
	
	@Autowired
	private ClienteServiceImpl impl;
	
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		UsuarioDto usuarioDto = impl.obterUsuarioDto(userEmail);
		
		if(usuarioDto == null) {
			throw new IllegalArgumentException("Usuário não encontrado!!");
		}
		return  usuarioDto;
	}
	

}
