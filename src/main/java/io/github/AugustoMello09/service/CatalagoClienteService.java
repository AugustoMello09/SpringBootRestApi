package io.github.AugustoMello09.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.AugustoMello09.exception.NegocioException;
import io.github.AugustoMello09.model.Cliente;
import io.github.AugustoMello09.repository.ClienteRepository;

@Service
public class CatalagoClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
	boolean emailEmUso  =	clienteRepository.findByEmail(cliente.getEmail())
			.stream()
			.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
	if(emailEmUso) {
		throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
	}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void deletar(Long clienteId) {
	  clienteRepository.deleteById(clienteId);
	}

	
}
