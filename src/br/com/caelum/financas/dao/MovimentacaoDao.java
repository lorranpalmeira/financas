package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;


import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {
	
	
	//Classe usada para organizar DAO
	private EntityManager manager;
	
	public MovimentacaoDao(EntityManager manager){
		this.manager = manager;
		
	}
	
    public Double mediaDaContaPeloTipo(Conta conta, TipoMovimentacao tipo) {

        javax.persistence.TypedQuery<Double> query =  manager.createQuery(
                "select avg(m.valor) from Movimentacao m where m.conta=:pConta "
                        + " and m.tipoMovimentacao = :pTipo", Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", tipo);

        return query.getSingleResult();
    }
	
	
}
