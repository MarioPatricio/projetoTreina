package com.resume.jpa.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
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
@Table(name = "endereco")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonIgnore
	@OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
	private Identidade identidade;
	
	@Column(name = "rua", nullable = false)
	private String rua;

	@Column(name = "num", nullable = false)
	private int num;
	
	@Column(name = "bairro", nullable = false)
	private String bairro;
	
	@Column(name = "cep", length = 10, nullable = false)
	private String cep;
	
	@Column(name = "cidade", nullable = false)
	private String cidade;
	
	@Column(name = "uf", length = 2, nullable = false)
	private String uf;

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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
