package com.tqi.evolution.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tqi.evolution.model.Emprestimo;

public interface EmprestimoRepository extends MongoRepository<Emprestimo, String> {
	
	@Query("{'Cliente.idCliente':?0}")
	List<Emprestimo> obterPorIdCliente(String idCliente);
}
