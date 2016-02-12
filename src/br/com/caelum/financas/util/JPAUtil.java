package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private final static EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("contas-mysql");

	public EntityManager getEntityManager() {
		return entityManager.createEntityManager();
	}

}
