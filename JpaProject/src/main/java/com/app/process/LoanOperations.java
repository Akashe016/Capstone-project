package com.app.process;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LoanOperations {

	public static void main(String args[]) {

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("JpaProject");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Loan l1 = new Loan();

		//l1.setId(1);
		//l1.setLoanDesc("home loan");
		//l1.setLoanname("homeloan");

		//l1.setId(1);
		//l1.setLoanDesc("car loan");
		//l1.setLoanname("car loan");

		//em.persist(l1);
		//Loan l2 = em.find(Loan.class, 1);
		
		//l2.set.Loanname("car processing loan");
		
		//em.merge(l2); //update
		
		// em.remove(12); //delete
		
		//select all object
		Query query = em.createQuery("select t from Loan t");
		
		List<Loan> loandetails = query.getResultList();
		
		System.out.println("Total :"+loandetails.size());
		em.getTransaction().commit();

		}
}
