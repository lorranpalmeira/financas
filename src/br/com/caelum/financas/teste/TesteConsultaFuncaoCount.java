package br.com.caelum.financas.teste;

import javax.management.Query;
import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(3);

		javax.persistence.Query query = manager.createQuery("select count(m) from Movimentacao m where m.conta = :pConta");
		query.setParameter("pConta", conta);        
		Long quantidade=  (Long) query.getSingleResult();

		System.out.println("A conta possui " + quantidade + " movimentações.");

	}

}
