package io.github.AugustoMello09.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import io.github.AugustoMello09.model.enums.StatusEntrega;
import io.github.AugustoMello09.model.utils.ValidationGroups;

@Entity
public class Entrega {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
	@NotNull
	@ManyToOne
	private Cliente cliente;
	
	@Valid
	@NotNull
	@Embedded
	private Destinatario destinatario;
	
	@NotNull
	private BigDecimal taxa;
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private StatusEntrega status;

	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime dataPedido;

	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime dataFinalizacao;

	public Entrega() {
		
	}
	
	public Entrega(Long id, Cliente cliente, Destinatario destinatario, BigDecimal taxa, StatusEntrega status,
			LocalDateTime dataPedido, LocalDateTime dataFinalizacao) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.destinatario = destinatario;
		this.taxa = taxa;
		this.status = status;
		this.dataPedido = dataPedido;
		this.dataFinalizacao = dataFinalizacao;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destinatario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public StatusEntrega getStatus() {
		return status;
	}

	public void setStatus(StatusEntrega status) {
		this.status = status;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrega other = (Entrega) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
