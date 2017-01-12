package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsulta {
	
	public static void main(String[] args){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		//Parameter Notation
        // Query query = manager
        //         .createQuery("select m from Movimentacao m where m.conta=?1"
        //                 + " and m.tipoMovimentacao=?2");

        // query.setParameter(1, conta);
        // query.setParameter(2, TipoMovimentacao.ENTRADA);
		
		
		//##########
		// Named Notation
        ///Query query = manager
        //        .createQuery("select m from Movimentacao m where m.conta = :pConta"
        //                + " and m.tipoMovimentacao = :pTipo"
        //                + " order by m.valor desc");
        //query.setParameter("pConta", conta);
        //query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		
		
		Query query = manager.createQuery("select m from Movimentacao m where m.conta=:pConta" // se quiser fechar aqui );
		+ " order by m.valor desc"); // Fazendo orderBy pelo valor
		
		//Passando o objeto conta para ser filtado no where
		;
		query.setParameter("pConta", conta);
		
        List<Movimentacao> movimentacoes = query.getResultList();
        
        System.out.println("\n ####  testBefore ##### ");
        
        for (Movimentacao m : movimentacoes) {
            System.out.println("\nDescricao ..: " + m.getDescricao());
            System.out.println("Valor ......: R$ " + m.getValor());
        }
		
		System.out.println("\n ####  testeAfter ##### ");
		
		
		
		
		
	}

}
