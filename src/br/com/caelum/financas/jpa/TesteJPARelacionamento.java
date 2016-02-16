package br.com.caelum.financas.jpa;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		double inicio = System.currentTimeMillis();

		Conta conta = new Conta();
		conta.setTitular("Maria dos Santos");
		conta.setBanco("Caixa");
		conta.setAgencia("043");
		conta.setNumero("54321");
		conta.setSaldo(new BigDecimal(653.82));

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de Luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("123.9"));

		movimentacao.setConta(conta);

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		em.persist(conta);
		em.persist(movimentacao);

		em.getTransaction().commit();
		em.close();

		double fim = System.currentTimeMillis();
		System.out.println("Executado em: " + (fim - inicio) / 1000 + "s");
	}
}
