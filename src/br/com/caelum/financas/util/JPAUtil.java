package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	public static EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("financas");
	
	
	public EntityManager getEntityManager(){
		
		return entitymanagerfactory.createEntityManager();
	}

}
