package com.webmobile.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.webmobile.trabalho.dto.PacienteDTO;
import com.webmobile.trabalho.service.PacienteService;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteService service;
	
	@PostMapping(value = "/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public PacienteDTO salvar (@RequestBody PacienteDTO dto) {
		return service.salvar(dto);
	}
}
