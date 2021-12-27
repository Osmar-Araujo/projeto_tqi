package com.tqi.evolution.service;

import java.util.List;

import com.tqi.evolution.model.Emprestimo;

public interface EmprestimoService {
	public List<Emprestimo> obterTodos();
	public Emprestimo obterPorCodigo(String codigo);
	public Emprestimo criarEmprestimo(Emprestimo emprestimo);
}
