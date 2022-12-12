package io.github.AugustoMello09.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.AugustoMello09.model.Entrega;
import io.github.AugustoMello09.repository.EntregaRepository;

@Service
public class FinalizacaoEntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public void finalizar (Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		
		entrega.finalizar();
		
		entregaRepository.save(entrega);
	}
}
