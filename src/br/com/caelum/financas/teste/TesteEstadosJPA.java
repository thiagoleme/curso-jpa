package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteEstadosJPA {

	@Test
	public void testaEstadoManagedFind() throws Exception {
		EntityManager entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();

		Conta conta = entityManager.find(Conta.class, 1);

		System.out.println(conta.getTitular());

		// Alterando o titular da conta
		conta.setTitular("Luiz Ferreira");

		System.out.println(conta.getTitular());

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@Test
	public void testaEstadoTransientInclusao() {
		Conta conta = new Conta();
		conta.setTitular("Fabio Alameida111");
		conta.setBanco("HSBC");
		conta.setNumero("123345");
		conta.setAgencia("321");

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		// Testes do capitulo
		manager.persist(conta);

		manager.getTransaction().commit();

		manager.close();
	}
}