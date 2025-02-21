package com.resume.jpa.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resume.jpa.models.Endereco;
import com.resume.jpa.models.Experiencia;
import com.resume.jpa.models.Formacao;
import com.resume.jpa.models.Identidade;
import com.resume.jpa.models.InfoAdicional;
import com.resume.jpa.repositories.EnderecoRepository;
import com.resume.jpa.repositories.ExperienciaRepository;
import com.resume.jpa.repositories.FormacaoRepository;
import com.resume.jpa.repositories.IdentidadeRepository;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
@Getter
@Setter
public class IdentidadeController {
	
	@Autowired
	private final IdentidadeRepository identidadeRepository;
	
	@Autowired
	private final FormacaoRepository formacaoRepository;
	
	@Autowired
	private final ExperienciaRepository experienciaRepository;
	
	@Autowired
	private final EnderecoRepository enderecoRepository;
	
	public IdentidadeController(IdentidadeRepository identidadeRepository, FormacaoRepository formacaoRepository, ExperienciaRepository experienciaRepository, EnderecoRepository enderecoRepository) {
		this.identidadeRepository = identidadeRepository;
		this.formacaoRepository = formacaoRepository;
		this.experienciaRepository = experienciaRepository;
		this.enderecoRepository = enderecoRepository;
	}
	
	@GetMapping(value = "/buscarTudo")
	public List<Identidade> buscarTudo() {
		return identidadeRepository.findAll();
	}
	
	@PostMapping(value = "/cadastrarCurriculo")
	public Identidade cadastrarCurriculo(@RequestBody Identidade identidade) {
		InfoAdicional info = identidade.getInfoAdicional();
		if (info != null) {
		info.setIdentidade(identidade);
		}
		Identidade resposta = identidadeRepository.save(identidade);
		Set<Formacao> formacoes = identidade.getFormacoes();
		if (formacoes != null) {
			for(Formacao formacao:formacoes) {
				formacao.setIdentidade(identidade);
				formacaoRepository.save(formacao);
			}
		}
		Set<Experiencia> experiencias = identidade.getExperiencias();
		if (experiencias != null) {
			for(Experiencia experiencia:experiencias) {
				experiencia.setIdentidade(identidade);
				experienciaRepository.save(experiencia);
			}
		}
		return resposta;
	}
	
	@PutMapping(value = "/atualizarCurriculo/{id}")
	public Identidade atualizarCurriculo(@PathVariable Long id, @RequestBody Identidade identidadeNova) {
		Identidade identidade = identidadeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Currículo não encontrado."));
		Endereco enderecoNovo = identidadeNova.getEndereco();
		Endereco endereco = identidade.getEndereco();
		if (endereco != null) {
			endereco.setBairro(enderecoNovo.getBairro());//Terminar campos
			endereco.setCep(enderecoNovo.getCep());
			endereco = enderecoRepository.save(endereco);
			identidade.setEndereco(endereco);
			}
		if (identidadeNova.getInfoAdicional() != null) {
			InfoAdicional info = identidade.getInfoAdicional();
			info.setInfo1(identidadeNova.getInfoAdicional().getInfo1());
			info.setInfo2(identidadeNova.getInfoAdicional().getInfo2());
			identidade.setInfoAdicional(info);
			}
		if (identidadeNova.getExperiencias() != null) {
            experienciaRepository.deleteAll(identidade.getExperiencias());
            Set<Experiencia> novasExperiencias = identidadeNova.getExperiencias();
            for (Experiencia novaExperiencia : novasExperiencias) {
                novaExperiencia.setIdentidade(identidade);
            }
            identidade.setExperiencias(novasExperiencias);
        }
		identidadeRepository.save(identidade);
		return identidade;
	}
	
	
	
	

}
