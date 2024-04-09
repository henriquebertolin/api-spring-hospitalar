package com.webmobile.trabalho.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	@GetMapping(value = "/findAll")
	@ResponseStatus(HttpStatus.OK)
	public List<PacienteDTO> findAll () {
		return service.findAll();
	}
	
	@GetMapping(value = "/findById")
	@ResponseStatus(HttpStatus.OK)
	public Optional<PacienteDTO> findById(@RequestHeader (value = "cdPaciente") Long cdPaciente) {
		return service.findById(cdPaciente);
	}
	
	@PutMapping(value = "/atualizar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar (@RequestBody PacienteDTO dto) {
		service.atualizaPaciente(dto);
	}
	
	@DeleteMapping(value = "/deletar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar (@RequestHeader (value = "cdPaciente") Long cdPaciente) {
		service.deletaUsuario(cdPaciente);
	}
	
}
