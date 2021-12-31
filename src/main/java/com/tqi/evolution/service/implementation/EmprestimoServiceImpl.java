package com.tqi.evolution.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqi.evolution.model.Cliente;
import com.tqi.evolution.model.Emprestimo;
import com.tqi.evolution.repository.ClienteRepository;
import com.tqi.evolution.repository.EmprestimoRepository;
import com.tqi.evolution.service.EmprestimoService;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {
	
	@Autowired
	private EmprestimoRepository repository;
	
	@Autowired
	private ClienteRepository cliRepository;

	@Override
	public List<Emprestimo> obterTodos() {
		return this.repository.findAll();
	}


	public String criar(Emprestimo emprestimo) {
		Cliente cliente = this.cliRepository.
				findById(emprestimo.getCliente().getIdCliente()).
				orElseThrow(() -> new IllegalArgumentException("Cliente inexistente!!"));
		emprestimo.setCliente(cliente);
		this.repository.save(emprestimo);
		return "Emprestimo solicitado com sucesso!!" + emprestimo;
	}


	@Override
	public Emprestimo obterPorCodigo(String idEmprestimo) {
		return repository.findById(idEmprestimo).orElseThrow(() -> new IllegalArgumentException("Emprestimo inexistente!!"));
	}


	@Override
	public List<Emprestimo> obterPorIdCliente(String idCliente) {
		return this.repository.obterPorIdCliente(idCliente);
	}

}
