package com.webmobile.trabalho.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.webmobile.trabalho.dto.PacienteDTO;
import com.webmobile.trabalho.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository repository;
	
	public PacienteDTO salvar(PacienteDTO dto) {
		dto.setSnPacienteAtivo(Boolean.TRUE);
		return repository.save(dto);
	}
	
	public List<PacienteDTO> findAll () {
		return repository.listarTodos();
	}
	
	public Optional<PacienteDTO> findById(Long cdPaciente) {
		Optional<PacienteDTO> paciente = repository.findPacienteById(cdPaciente);
		if (paciente.isPresent()) {
			return paciente;
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Paciente inexistente ou inativo.");
		}
	}
	
	public void atualizaPaciente (PacienteDTO dto) {
		Optional<PacienteDTO> paciente = findById(dto.getCdPaciente());
		if (paciente.isPresent()) {	
			if (dto.getNmPaciente() == null) {dto.setNmPaciente(paciente.get().getNmPaciente());}
			if (dto.getDtNascimento() == null) {dto.setDtNascimento(paciente.get().getDtNascimento());}
			if (dto.getDsRg() == null) {dto.setDsRg(paciente.get().getDsRg());}
			if (dto.getDsEmail() == null) {dto.setDsEmail(paciente.get().getDsEmail());}
			if (dto.getDsCpf() == null) {dto.setDsCpf(paciente.get().getDsCpf());}
			repository.updatePaciente(dto.getNmPaciente(), dto.getDsCpf(), dto.getDsRg(), dto.getDtNascimento(), dto.getDsEmail(), dto.getCdPaciente());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Paciente não encontrado");
		}
	}
	
	public void deletaUsuario(Long cdPaciente) {
		Optional<PacienteDTO> paciente = findById(cdPaciente);
		if (paciente.isPresent()) {
			repository.deletaPaciente(cdPaciente);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Paciente não encontrado");

		}
	}
	
	
}
