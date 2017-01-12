package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;


import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {
		
		double inicio = System.currentTimeMillis();
		
		Conta conta = new Conta();
		/*
		conta.setTitular("Jao");
		conta.setBanco("Itaú");
		conta.setNumero("556987");
		conta.setAgencia("0240");
		*/
		
		conta.setId(16);
		conta.setBanco("104 - CAIXA ECONOMICA FEDERAL");
		conta.setNumero("98654-4");
		conta.setAgencia("4321");
		conta.setTitular("Alexandre Fonseca");
		
		/*
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas");
		
		EntityManager manager = entityManagerFactory.createEntityManager();
		*/
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		
		manager.getTransaction().begin();
		
		manager.merge(conta); // Merge é usado para quando o objeto está desatachado e precisa ser alterado.
		//manager.persist(conta);
		
		manager.getTransaction().commit();
		
		
		manager.close();
		
		double fim = System.currentTimeMillis();
		System.out.println("Executado em "+(fim - inicio)/1000+" s");

	}

}
