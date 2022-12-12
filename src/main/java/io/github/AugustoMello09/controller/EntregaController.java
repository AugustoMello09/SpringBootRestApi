package io.github.AugustoMello09.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.AugustoMello09.assembler.EntregaAssembler;
import io.github.AugustoMello09.dto.EntregaDTO;
import io.github.AugustoMello09.model.Entrega;
import io.github.AugustoMello09.model.input.EntregaInput;
import io.github.AugustoMello09.repository.EntregaRepository;
import io.github.AugustoMello09.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private EntregaAssembler assembler;

	@Autowired
	private SolicitacaoEntregaService service;

	@Autowired
	private EntregaRepository entregaRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDTO solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega novaEntrega = assembler.toEntity(entregaInput);
		Entrega entregaSolicitada = service.solicitar(novaEntrega);

		return assembler.toModel(entregaSolicitada);
	}

	@GetMapping
	public List<EntregaDTO> listar() {
		return assembler.toCollectionModel(entregaRepository.findAll());
	}

	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId).map(entrega -> ResponseEntity.ok(assembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());

	}
}
