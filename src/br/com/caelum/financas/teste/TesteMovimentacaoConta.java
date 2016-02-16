package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 2);
		
		System.out.println(movimentacao.getConta().getTitular());
		
		em.close();
	}
}
