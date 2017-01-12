package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteEstadoJPA {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class,19); // O find passado a classe e o id classe ref BD - Faz uma busca do id no BD
		System.out.println(conta.getTitular());
		
		//Novo código deixando em Managed e alterando o valor 
			
		System.out.println(conta.getTitular());

        // Alterando o titular da conta
        conta.setTitular("Luiz Ferreira"); // Vejamos que foi alterado no BD para este novo valor.

        System.out.println(conta.getTitular());
		
		//
		
		em.getTransaction().commit();
		em.close();


	}

}
