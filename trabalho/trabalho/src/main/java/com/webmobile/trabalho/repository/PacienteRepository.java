package com.webmobile.trabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webmobile.trabalho.dto.PacienteDTO;

public interface PacienteRepository extends JpaRepository<PacienteDTO, Long>{

}
