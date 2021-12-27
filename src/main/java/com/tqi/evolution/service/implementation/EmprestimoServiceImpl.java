package com.tqi.evolution.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqi.evolution.model.Emprestimo;
import com.tqi.evolution.repository.EmprestimoRepository;
import com.tqi.evolution.service.EmprestimoService;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {
	
	@Autowired
	private EmprestimoRepository repository;

	@Override
	public List<Emprestimo> obterTodos() {
		return this.repository.findAll();
	}

	@Override
	public Emprestimo obterPorCodigo(String codigo) {
		return this.repository.findById(codigo).orElseThrow();
	}

	@Override
	public Emprestimo criarEmprestimo(Emprestimo emprestimo) {
		return this.repository.save(emprestimo);
	}

}
