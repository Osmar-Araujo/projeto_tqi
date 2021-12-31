package com.tqi.evolution.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document(collection = "emprestimos")
public class Emprestimo {

	@Id
	private String idEmprestimo;
	
	private BigDecimal valorEmprestimo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataPrimeiraParcela;
	private int numeroParcela;
	private Cliente cliente;
	
}
