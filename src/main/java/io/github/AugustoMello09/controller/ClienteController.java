package io.github.AugustoMello09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.AugustoMello09.model.Cliente;
import io.github.AugustoMello09.repository.ClienteRepository;

@RestController
public class ClienteController {
	
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
}
