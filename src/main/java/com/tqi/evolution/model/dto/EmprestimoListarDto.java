package com.tqi.evolution.model.dto;

import java.math.BigDecimal;

import com.tqi.evolution.model.Emprestimo;

import lombok.Data;

@Data
public class EmprestimoListarDto {
	private String codigoEmprestimo;
	private BigDecimal valorEmprestimo;
	private int qtdParcelas;
	
	public EmprestimoListarDto(Emprestimo emprestimo) {
		this.codigoEmprestimo = emprestimo.getIdEmprestimo();
		this.valorEmprestimo = emprestimo.getValorEmprestimo();
		this.qtdParcelas = emprestimo.getNumeroParcela();
	}
}
