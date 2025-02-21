package com.resume.jpa.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "identidade")
public class Identidade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "identidade", fetch = FetchType.LAZY)
	private Set<Formacao> formacoes = new HashSet<>();
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "identidade", fetch = FetchType.LAZY)
	private Set<Experiencia> experiencias = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_enderecoid")
	private Endereco endereco;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToOne(mappedBy = "identidade", cascade = CascadeType.ALL)
	private InfoAdicional infoAdicional;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "foto", nullable = false)
	private String foto;
	
	@Column(name = "telefone", length = 15, nullable = false)
	private String telefone;
	
	@Column(name = "email")
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Formacao> getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(Set<Formacao> formacoes) {
		this.formacoes = formacoes;
	}

	public Set<Experiencia> getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(Set<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public InfoAdicional getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(InfoAdicional infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
