package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFind {

	public static void main(String[] args) {
		
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		
		manager.getTransaction().begin();
		
		
		/* Removendo objeto em uma linha do banco de dados
		Conta conta = manager.find(Conta.class, 5);
		manager.remove(conta);
		*/
		
		Conta conta = manager.find(Conta.class, 4); // Recupendado objeto no banco de dados.
		System.out.println("O Titular é " + conta.getTitular());
		
		manager.getTransaction().commit();
		manager.close();
		
		
		
	}

}
