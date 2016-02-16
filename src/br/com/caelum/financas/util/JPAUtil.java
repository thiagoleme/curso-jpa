package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	/**
	 * Usando MySQL
	 */
	private final static EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("contas-mysql");

	/**
	 * Usando HSQLDB
	 */
	// private final static EntityManagerFactory entityManager =
	// Persistence.createEntityManagerFactory("contas-hsqldb");

	/**
	 * Usando PostgreSQL
	 */
	// private final static EntityManagerFactory entityManager = Persistence
	// .createEntityManagerFactory("contas-postgres");

	public EntityManager getEntityManager() {
		return entityManager.createEntityManager();
	}

}
