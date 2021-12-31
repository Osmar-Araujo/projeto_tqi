package com.tqi.evolution.service;

import java.util.List;

import com.tqi.evolution.model.Emprestimo;

public interface EmprestimoService {
	public Emprestimo obterPorCodigo(String codigo);
	public String criar(Emprestimo emprestimo);
	List<Emprestimo> obterTodos();
	List<Emprestimo> obterPorIdCliente(String idCliente);
}
