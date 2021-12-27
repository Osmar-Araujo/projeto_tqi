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

	@Override
	public Emprestimo obterPorCodigo(String codigo) {
		return this.repository.findById(codigo).orElseThrow(() -> new IllegalArgumentException("Emprestimo inexistente!!"));
	}

	@Override
	public Emprestimo criar(Emprestimo emprestimo) {
		
		Cliente cliente = this.cliRepository.
				findById(emprestimo.getCliente().getIdCliente()).
				orElseThrow(() -> new IllegalArgumentException("Cliente inexistente!!"));
		emprestimo.setCliente(cliente);
		return this.repository.save(emprestimo);
	}

}
