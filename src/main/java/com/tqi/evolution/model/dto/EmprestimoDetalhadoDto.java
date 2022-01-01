package com.tqi.evolution.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmprestimoDetalhadoDto {
	private String codigoEmprestimo;
	private BigDecimal valorEmprestimo;
	private int qtdParcelas;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataPrimeiraParcela;
	private String emailCliente;
	private BigDecimal rendaCliente;

}
