package com.webmobile.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.webmobile.trabalho.dto.PlanoSaudeDTO;
import com.webmobile.trabalho.service.PlanoSaudeService;

@RestController
@RequestMapping(value = "/planoSaude")
public class PlanoSaudeController {
	
	@Autowired
	private PlanoSaudeService service;
	
	@PostMapping(value = "/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public PlanoSaudeDTO salvar(@RequestBody PlanoSaudeDTO dto) {
		return service.salvar(dto);
	}
}
