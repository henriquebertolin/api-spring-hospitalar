package com.webmobile.trabalho.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

@Entity
@Table(name = "pacientes")
public class PacienteDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_usuario")
	private Long cdUsuario;
	
	@Column(name = "nm_paciente")
	private String nmPaciente;
	
	@Column(name = "ds_cpf")
	private String dsCpf;
	
	@Column(name = "ds_rg")
	private String dsRg;
	
    @JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dt_nascimento")
	private LocalDate dtNascimento;
	
	@Column(name = "ds_email")
	private String dsEmail;
	
	@Column(name = "ds_senha")
	private String dsSenha;
	
	@Column(name = "dt_hora_alterado")
	private LocalDateTime dtHoraAlterado;
	
}
