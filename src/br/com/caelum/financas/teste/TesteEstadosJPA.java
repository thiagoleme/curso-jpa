package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteEstadosJPA {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setId(123456);
		conta.setTitular("Fabio Alameida111");
		conta.setBanco("HSBC");
		conta.setNumero("123345");
		conta.setAgencia("321");
		
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		// Testes do capitulo
		manager.merge(conta);

		manager.getTransaction().commit();

		manager.close();

	}
}