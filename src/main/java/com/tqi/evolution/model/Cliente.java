package com.tqi.evolution.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="clientes")
public class Cliente {
	
	@Id
	private String idCliente;
	
	private String nome;
	
	private String email;
	
	private String cpf;
	
	private String rg;
	
	private BigDecimal renda;
	
	private String senha;
	
	private Endereco endereco;
	
	private List<Emprestimo> emprestimos;
	
	public Cliente() {
		
	}
	
}
