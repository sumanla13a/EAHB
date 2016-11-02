package edu.mum.hw2.control;

import java.io.IOException;
import java.io.Serializable;

import java.nio.file.*;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.domain.Actor;
import edu.mum.hw2.domain.Movie;


public class Application {

	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {

		addMovies();
		printMoviesReport();
		emf.close();
	}

	private static void printMoviesReport() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.createQuery("from Movie").getResultList().forEach(System.out::println);
	}

	private static void addMovies() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Actor suman = new Actor();
			suman.setCharacter("hero");
			suman.setRating(5);
			suman.setName("SUperMAN");
			Movie movie = new Movie();
			List<Actor> sumanActs = new ArrayList<Actor>();
			sumanActs.add(suman);
			movie.setActors(sumanActs);
			movie.setCover(Files.readAllBytes(Paths.get("Pics/p.jpg")));
			movie.setName("Khatra Movie 1");
			movie.setRating(1);
			em.persist(movie);
			/*Movie movie1 = new Movie();
			movie1.setCover(Files.readAllBytes(Paths.get("Pics/p1.jpg")));
			movie1.setName("Khatra Movie 2");
			movie1.setRating(2);
			em.persist(movie1);*/
			/*Files.walk(Paths.get("Pics")).forEach(n-> {
				Movie movie = new Movie();
				System.out.println(n);
				try {
					movie.setCover(Files.readAllBytes(n));
					movie.setName("Khatra Movie " + ap);
					movie.setRating(ap);
					em.persist(movie);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});;*/
		// TODO your code


//			em.persist(movie);

			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
	}

}
