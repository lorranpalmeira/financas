package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {
	
	public static void main(String[] args){
		
		EntityManager manager = new  JPAUtil().getEntityManager();
		
		//Movimentacao movimentacao = manager.find(Movimentacao.class, 2);
		
		Query query = manager.createQuery("select c from Conta c where id=?1");
		query.setParameter(1, 4); //Passagem de parametro com id=4;
		
		List<Conta> contas = query.getResultList();
		
		for(Conta conta : contas){
			System.out.println("Quantidade de Movimentações: "+ conta.getMovimentacoes().size());
		}
		
		
		//System.out.println("A conta é de "+ movimentacao.getConta().getTitular());
		
		
	}

}
