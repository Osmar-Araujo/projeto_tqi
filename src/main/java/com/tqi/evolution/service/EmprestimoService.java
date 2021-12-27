package com.tqi.evolution.service;

import java.util.List;

import com.tqi.evolution.model.Emprestimo;

public interface EmprestimoService {
	public List<Emprestimo> obterPorCliente();
	public Emprestimo obterPorCodigo(String codigo);
	public Emprestimo criar(Emprestimo emprestimo);
}
