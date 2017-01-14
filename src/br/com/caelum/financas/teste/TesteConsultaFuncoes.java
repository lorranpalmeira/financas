package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncoes {
	
	public static void main(String[] args){
		
        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(3);

        MovimentacaoDao dao = new MovimentacaoDao(manager);
        
        
        
        /*
         * Será subtituído pelo movimentacaodao
        String jpql = "select sum(m.valor) from Movimentacao m where m.conta=:pConta "
                + "and m.tipoMovimentacao=:pTipo";

        javax.persistence.TypedQuery<BigDecimal> query = manager.createQuery(jpql, BigDecimal.class); // TypedQuery para retorna BigDecimal

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        BigDecimal resultado =  query.getSingleResult();

        System.out.println("Total movimentado ..: R$ " + resultado);
        */ 
        
        /*
         * Será subtituído pelo movimentacaodao
        // O tipo avg() retorna Double então é preciso mudar o TypedQuery do que tem acima que é BigDecimal retornado pelo sum()
        String jpql = "select avg(m.valor) from Movimentacao m where m.conta=:pConta "
                + "and m.tipoMovimentacao=:pTipo";

        javax.persistence.TypedQuery<Double> query = manager.createQuery(jpql, Double.class); // TypedQuery para retorna BigDecimal

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        Double resultado =  query.getSingleResult();
        
        */

        System.out.println("Total movimentado ..: R$ " + dao.mediaDaContaPeloTipo(conta, TipoMovimentacao.SAIDA));
        
        
        
        //Método antigo sem classe DAO
        //System.out.println("Total movimentado ..: R$ " + resultado);
		
		
		
		
		
	}

}
