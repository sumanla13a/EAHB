package edu.mum.hw2.dao;

import javax.persistence.*;

public class Session {
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public EntityManager getEM() {
		return emf.createEntityManager();
	}
}
