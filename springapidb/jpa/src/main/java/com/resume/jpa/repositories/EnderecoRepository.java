package com.resume.jpa.repositories;

import com.resume.jpa.models.Endereco;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	Optional<Endereco>findByRua(String rua);

}
