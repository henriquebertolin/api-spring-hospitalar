package com.webmobile.trabalho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webmobile.trabalho.dto.PacienteDTO;
import com.webmobile.trabalho.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository repository;
	
	public PacienteDTO salvar(PacienteDTO dto) {
		return repository.save(dto);
	}
	
	
}
