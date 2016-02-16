package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteContaMovimentacoes {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
//		Conta conta = manager.find(Conta.class, 1);
		Conta conta = new Conta();
		conta.setId(1);
		
		Query query = manager.createQuery("select distinct c from Conta c join fetch c.movimentacoes where c = :pConta");
		query.setParameter("pConta", conta);
		
		conta = (Conta) query.getSingleResult();
		
		manager.close();
		
		System.out.println(conta.getMovimentacoes().size());
		
	}
}
