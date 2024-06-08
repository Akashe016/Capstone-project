package com.app.process;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("JpaProject");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		// insert
		
		User u1 = new User();

		u1.setId(2);
		u1.setName("santhosh");
		u1.setAge(23);
		u1.setCity("Trichy");
			
		em.persist(u1);
		em.getTransaction().commit();

//-----------------------------------------------------------------------------
		
		// update
		
		//Loan l2 = em.find(Loan.class, 1);
		
		//l2.set.name("Santhosh");
		
		//em.merge(l2); 
		
		//em.getTransaction().commit();
//------------------------------------------------------------------------------------
		
		// delete
		
		//Loan l2 = em.find(Loan.class, 1);

		//em.remove(12); 
		//em.getTransaction().commit();

//-----------------------------------------------------------------------------------	
		
		//select all object
		
		//Query query = em.createQuery("select t from Loan t");
		
	//	List<User> loandetails = query.getResultList();
		
	//	System.out.println("Total :"+loandetails.size());
	//	em.getTransaction().commit();

	}

}
