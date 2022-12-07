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

import io.github.AugustoMello09.dto.DestinatarioDTO;
import io.github.AugustoMello09.dto.EntregaDTO;
import io.github.AugustoMello09.model.Entrega;
import io.github.AugustoMello09.repository.EntregaRepository;
import io.github.AugustoMello09.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private SolicitacaoEntregaService service;

	@Autowired
	private EntregaRepository entregaRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
		return service.solicitar(entrega);
	}

	@GetMapping
	public List<Entrega> listar() {
		return entregaRepository.findAll();
	}

	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId).map(obj -> {
			EntregaDTO entregaDto = new EntregaDTO();
			entregaDto.setId(obj.getId());
			entregaDto.setNomeCliente(obj.getCliente().getNome());
			entregaDto.setDestinatario(new DestinatarioDTO());
			entregaDto.getDestinatario().setNome(obj.getDestinatario().getNome());
			entregaDto.getDestinatario().setLogradouro(obj.getDestinatario().getLogradouro());
			entregaDto.getDestinatario().setNumero(obj.getDestinatario().getNumero());
			entregaDto.getDestinatario().setComplemento(obj.getDestinatario().getComplemento());
			entregaDto.getDestinatario().setBairro(obj.getDestinatario().getBairro());
			entregaDto.setTaxa(obj.getTaxa());
			entregaDto.setStatus(obj.getStatus());
			entregaDto.setDataPedido(obj.getDataPedido());
			entregaDto.setDataFinalizacao(obj.getDataFinalizacao());

			return ResponseEntity.ok(entregaDto);
		}).orElse(ResponseEntity.notFound().build());
	}
}
