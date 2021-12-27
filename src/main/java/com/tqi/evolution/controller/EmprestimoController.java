package com.tqi.evolution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tqi.evolution.model.Emprestimo;
import com.tqi.evolution.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
	
	@Autowired
	private EmprestimoService service;
	
	
	@GetMapping
	public List<Emprestimo> obterTodos(){
		return this.service.obterTodos();
	}
	
	@GetMapping("/{codigo}")
	public Emprestimo obterPorCodigo(@PathVariable String codigo) {
		return service.obterPorCodigo(codigo);
	}
	
	@PostMapping
	public Emprestimo criarEmprestimo(@RequestBody Emprestimo emprestimo) {
		return this.service.criar(emprestimo);
	}
}
