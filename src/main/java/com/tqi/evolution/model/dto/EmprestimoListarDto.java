package com.tqi.evolution.model.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class EmprestimoListarDto {
	private String codigoEmprestimo;
	private BigDecimal valorEmprestimo;
	private int qtdParcelas;
	
}
