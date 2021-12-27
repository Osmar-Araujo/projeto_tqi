package com.tqi.evolution.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tqi.evolution.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{

}
