package io.github.AugustoMello09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.AugustoMello09.model.Entrega;
import io.github.AugustoMello09.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	@Autowired
	private SolicitacaoEntregaService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@RequestBody Entrega entrega) {
		return service.solicitar(entrega);
	}
	
}
