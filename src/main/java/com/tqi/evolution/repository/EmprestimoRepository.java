package com.tqi.evolution.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tqi.evolution.model.Cliente;
import com.tqi.evolution.model.Emprestimo;

public interface EmprestimoRepository extends MongoRepository<Emprestimo, String> {
	List<Emprestimo>findByCliente(Cliente cliente);
}
