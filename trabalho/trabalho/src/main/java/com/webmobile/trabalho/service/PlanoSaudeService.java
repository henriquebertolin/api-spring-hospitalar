package com.webmobile.trabalho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webmobile.trabalho.dto.PlanoSaudeDTO;
import com.webmobile.trabalho.repository.PlanoSaudeRepository;

@Service
public class PlanoSaudeService {
	
	@Autowired
	private PlanoSaudeRepository repository;
	
	public PlanoSaudeDTO salvar (PlanoSaudeDTO dto) {
		return repository.save(dto);
	}
}
