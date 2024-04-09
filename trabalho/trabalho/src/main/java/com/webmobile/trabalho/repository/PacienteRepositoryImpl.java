package com.webmobile.trabalho.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public abstract class PacienteRepositoryImpl implements PacienteRepository{
	@PersistenceContext
	private EntityManager em;
}
