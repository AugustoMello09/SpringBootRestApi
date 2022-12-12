package io.github.AugustoMello09.model.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class EntregaInput {
	@Valid
	@NotNull
	private ClienteIdInput cliente;

	@Valid
	@NotNull
	private DestinatarioInput destinario;
	
	@NotNull
	private BigDecimal taxa;

	public DestinatarioInput getDestinario() {
		return destinario;
	}

	public void setDestinario(DestinatarioInput destinario) {
		this.destinario = destinario;
	}

	public ClienteIdInput getCliente() {
		return cliente;
	}

	public void setCliente(ClienteIdInput cliente) {
		this.cliente = cliente;
	}
}
