package io.github.AugustoMello09.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.AugustoMello09.model.Cliente;
import io.github.AugustoMello09.model.Entrega;
import io.github.AugustoMello09.model.enums.StatusEntrega;
import io.github.AugustoMello09.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {
	@Autowired
	private CatalagoClienteService service;
	
	@Autowired
	private EntregaRepository entregaRepository;

	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = service.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRepository.save(entrega);
	}
}
