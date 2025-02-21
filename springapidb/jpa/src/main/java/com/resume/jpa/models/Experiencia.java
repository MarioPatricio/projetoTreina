package com.resume.jpa.models;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "experiencia")
public class Experiencia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//@JsonProperty(access = JsonProperty.Acess.WRITE_ONLY)
	@ManyToOne//(FETCH = FetchType.LAZY)
	@JoinColumn(name = "identidade_id")
	private Identidade identidade;
	
	@Column(name = "empresa")
	private String empresa;
	
	@Column(name = "inicio", length = 4, columnDefinition = "YEAR")
	private String inicio;
	
	@Column(name = "fim", length = 4, columnDefinition = "YEAR")
	private String fim;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Identidade getIdentidade() {
		return identidade;
	}

	public void setIdentidade(Identidade identidade) {
		this.identidade = identidade;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFim() {
		return fim;
	}

	public void setFim(String fim) {
		this.fim = fim;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
