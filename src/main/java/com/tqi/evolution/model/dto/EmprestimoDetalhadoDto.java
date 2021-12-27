package com.tqi.evolution.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class EmprestimoDetalhadoDto {
	private String codigoEmprestimo;
	private BigDecimal valorEmprestimo;
	private int qtdParcelas;
	private Date dataPrimeiraParcela;
	private String emailCliente;
	private BigDecimal rendaCliente;

}
