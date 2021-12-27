package com.tqi.evolution.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tqi.evolution.model.Emprestimo;

public interface EmprestimoRepository extends MongoRepository<Emprestimo, String> {

}
