package com.tqi.evolution.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "emprestimos")
public class Emprestimo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String idEmprestimo;
	
	private BigDecimal valorEmprestimo;
	private Date dataPrimeiraParcela;
	private int numeroParcela;
	private BigDecimal valorParcela;
	private Status status;
	
	@DBRef
	private Cliente cliente;

}
