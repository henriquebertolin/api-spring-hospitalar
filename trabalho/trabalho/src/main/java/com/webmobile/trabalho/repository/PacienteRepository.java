package com.webmobile.trabalho.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.webmobile.trabalho.dto.PacienteDTO;


public interface PacienteRepository extends JpaRepository<PacienteDTO, Long>{
	
	@Query(nativeQuery = true, value = "select * from pacientes where sn_paciente_ativo = true")
	public List<PacienteDTO> listarTodos();
	
	@Query(nativeQuery = true, value = "select * from pacientes where sn_paciente_ativo = true and cd_paciente = :cdPaciente")
	public Optional<PacienteDTO> findPacienteById(Long cdPaciente);
	
	@Query(nativeQuery = true, value = "update pacientes set nm_paciente = :nmPaciente, "
			+ "ds_cpf = :dsCpf, "
			+ "ds_rg = :dsRg, "
			+ "dt_nascimento = :dtNascimento, "
			+ "ds_email = :dsEmail, "
			+ "dt_hora_alterado = current_timestamp "
			+ "where cd_paciente = :cdPaciente ")
	@Modifying
	@Transactional(readOnly = false)
	public void updatePaciente(String nmPaciente, String dsCpf, String dsRg, LocalDate dtNascimento, String dsEmail, Long cdPaciente);
	
	@Query(nativeQuery = true, value = "update pacientes set sn_paciente_ativo = false where cd_paciente = :cdPaciente")
	@Modifying
	@Transactional(readOnly = false)
	public void deletaPaciente(Long cdPaciente);
	
}
