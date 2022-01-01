package com.tqi.evolution.service.implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqi.evolution.errors.IllegalArgument;
import com.tqi.evolution.errors.ResourceNotFoundException;
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
				orElseThrow(() -> new ResourceNotFoundException("Cliente inexistente!!"));
		emprestimo.setCliente(cliente);
		
		if(emprestimo.getNumeroParcela() > 60) {
			throw new IllegalArgument("O número de parcelas não deve ultrapassar 60!!");
		}
		
		LocalDate dataAtual = LocalDate.now();
		LocalDate maisTresMeses = dataAtual.plusMonths(3);
		
		if(emprestimo.getDataPrimeiraParcela().isAfter(maisTresMeses) || emprestimo.getDataPrimeiraParcela().isBefore(dataAtual)) {
			throw new IllegalArgument("A data da primeira paracela não pode ultrapassar 90 dias, nem pode ser retroativa!!");
		}
		
		this.repository.save(emprestimo);
		return "Emprestimo solicitado com sucesso!!" + emprestimo;
	}


	@Override
	public Emprestimo obterPorCodigo(String idEmprestimo) {
		return repository.findById(idEmprestimo).orElseThrow(() -> new IllegalArgument("Emprestimo inexistente!!"));
	}


	@Override
	public List<Emprestimo> obterPorIdCliente(String idCliente) {
		return this.repository.obterPorIdCliente(idCliente);
	}

}
