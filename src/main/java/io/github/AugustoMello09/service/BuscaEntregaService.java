package io.github.AugustoMello09.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.AugustoMello09.exception.EntidadeNÃ£oEncontradaException;
import io.github.AugustoMello09.model.Entrega;
import io.github.AugustoMello09.repository.EntregaRepository;

@Service
public class BuscaEntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega buscar(Long entregaId) {
	return entregaRepository.findById(entregaId)
			.orElseThrow(() -> new EntidadeNÃ£oEncontradaException("Entrega nÃ£o encontrada"));

	}
}