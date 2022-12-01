package io.github.AugustoMello09.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.AugustoMello09.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		Cliente cli1 = new Cliente();
		cli1.setId(1L);
		cli1.setNome("Teste1");
		cli1.setTelefone("93 97308-5660");
		cli1.setEmail("exampleTeste01@gmail.com");
		
		Cliente cli2 = new Cliente();
		cli2.setId(2L);
		cli2.setNome("Teste2");
		cli2.setTelefone("93 97301-8540");
		cli2.setEmail("exampleTeste02@gmail.com");
		
		return Arrays.asList(cli1, cli2);
	}
	
}
