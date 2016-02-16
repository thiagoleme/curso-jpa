package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteGerenciamentoJPA {

	@Test
	public void testaAlteracaoDepoisDoCommit() throws Exception {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();

		// ID de uma conta que exista no banco de dados, no caso ID: 1
		Conta conta = manager.find(Conta.class, 1);

		// commit antes da alteração
		manager.getTransaction().commit();

		// Alteração do titular da conta
		conta.setTitular("Caelum ensino e inovação");

		manager.getTransaction().begin();
		manager.merge(conta);
		manager.getTransaction().commit();

		manager.close();
	}

}
