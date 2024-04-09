package com.webmobile.trabalho.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public abstract class PlanoSaudeRepositoryImpl implements PlanoSaudeRepository{
	@PersistenceContext
	private EntityManager em;
}
