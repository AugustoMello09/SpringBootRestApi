package io.github.AugustoMello09.dto;

import java.time.OffsetDateTime;

public class OcorrenciaDTO {
	private Long id;
	private String descricao;
	private OffsetDateTime dataRegistro;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public OffsetDateTime getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(OffsetDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	
}
