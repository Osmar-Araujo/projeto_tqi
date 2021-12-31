package com.tqi.evolution.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tqi.evolution.model.Emprestimo;
import com.tqi.evolution.model.dto.EmprestimoDetalhadoDto;
import com.tqi.evolution.model.dto.EmprestimoListarDto;
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
	
	
	@GetMapping("lista/{idCliente}")
	public List<EmprestimoListarDto> obterPorIdClienteSimplificado(@PathVariable String idCliente){
		return this.service.obterPorIdCliente(idCliente)
				   .stream()
				   .map(this::toEmprestimoListarDto).collect(Collectors.toList());
	}
	
	@GetMapping("detalhado/{idEmprestimo}")
	public EmprestimoDetalhadoDto obterPorIdDetalhado(@PathVariable String idEmprestimo){
		 Emprestimo emprestimo = this.service.obterPorCodigo(idEmprestimo);
		 return toEmprestimoDetalhadoDto(emprestimo);
	}
	
	
	@PostMapping
	public String criarEmprestimo(@RequestBody Emprestimo emprestimo) {
		return this.service.criar(emprestimo);
	}
	
	private EmprestimoListarDto toEmprestimoListarDto(Emprestimo emprestimo) {
		
		EmprestimoListarDto emprestimoListarDto = new EmprestimoListarDto();
		emprestimoListarDto.setCodigoEmprestimo(emprestimo.getIdEmprestimo());
		emprestimoListarDto.setValorEmprestimo(emprestimo.getValorEmprestimo());
		emprestimoListarDto.setQtdParcelas(emprestimo.getNumeroParcela());
		return emprestimoListarDto;
	}
	
	private EmprestimoDetalhadoDto toEmprestimoDetalhadoDto(Emprestimo emprestimo) {
		EmprestimoDetalhadoDto emprestimoDetalhadoDto = new EmprestimoDetalhadoDto();
		emprestimoDetalhadoDto.setCodigoEmprestimo(emprestimo.getIdEmprestimo());
		emprestimoDetalhadoDto.setValorEmprestimo(emprestimo.getValorEmprestimo());
		emprestimoDetalhadoDto.setQtdParcelas(emprestimo.getNumeroParcela());
		emprestimoDetalhadoDto.setDataPrimeiraParcela(emprestimo.getDataPrimeiraParcela());
		emprestimoDetalhadoDto.setEmailCliente(emprestimo.getCliente().getEmail());
		emprestimoDetalhadoDto.setRendaCliente(emprestimo.getCliente().getRenda());
		return emprestimoDetalhadoDto;
	}
	
	
}
