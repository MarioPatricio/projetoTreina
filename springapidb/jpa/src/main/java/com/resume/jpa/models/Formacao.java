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
@Table(name = "formacao")
public class Formacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//@JsonProperty(access = JsonProperty.Acess.WRITE_ONLY)
	@ManyToOne//(FETCH = FetchType.LAZY)
	@JoinColumn(name = "identidade_id")
	private Identidade identidade;
	
	@Column(name = "graduacao")
	private String graduacao;
	
	@Column(name = "instituicaoGrad")
	private String instituicaoGrad;
	
	@Column(name = "anoGrad", length = 4, columnDefinition = "YEAR")
	private int anoGrad;
	
	@Column(name = "posGrad")
	private String posGrad;
	
	@Column(name = "instituicaoPosGrad")
	private String instituicaoPosGrad;
	
	@Column(name = "anoPosGrad", length = 4, columnDefinition = "YEAR")
	private int anoPosGrad;
	
	@Column(name = "tecnico")
	private String tecnico;
	
	@Column(name = "instituicaoTec")
	private String instituicaoTec;
	
	@Column(name = "anoTec", length = 4, columnDefinition = "YEAR")
	private int anoTec;

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

	public String getGraduacao() {
		return graduacao;
	}

	public void setGraduacao(String graduacao) {
		this.graduacao = graduacao;
	}

	public String getInstituicaoGrad() {
		return instituicaoGrad;
	}

	public void setInstituicaoGrad(String instituicaoGrad) {
		this.instituicaoGrad = instituicaoGrad;
	}

	public int getAnoGrad() {
		return anoGrad;
	}

	public void setAnoGrad(int anoGrad) {
		this.anoGrad = anoGrad;
	}

	public String getPosGrad() {
		return posGrad;
	}

	public void setPosGrad(String posGrad) {
		this.posGrad = posGrad;
	}

	public String getInstituicaoPosGrad() {
		return instituicaoPosGrad;
	}

	public void setInstituicaoPosGrad(String instituicaoPosGrad) {
		this.instituicaoPosGrad = instituicaoPosGrad;
	}

	public int getAnoPosGrad() {
		return anoPosGrad;
	}

	public void setAnoPosGrad(int anoPosGrad) {
		this.anoPosGrad = anoPosGrad;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public String getInstituicaoTec() {
		return instituicaoTec;
	}

	public void setInstituicaoTec(String instituicaoTec) {
		this.instituicaoTec = instituicaoTec;
	}

	public int getAnoTec() {
		return anoTec;
	}

	public void setAnoTec(int anoTec) {
		this.anoTec = anoTec;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
