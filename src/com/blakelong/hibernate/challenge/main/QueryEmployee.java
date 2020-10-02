package com.blakelong.hibernate.challenge.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blakelong.hibernate.challenge.entity.Employee;

public class QueryEmployee {
	
	public static void main(String[] args) {
		
		// create factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// begin transaction
			session.beginTransaction();
			
			// queries
			System.out.println("Show all employees");
			List<Employee> employees = session.createQuery("FROM Employee").getResultList();
			getResults(employees);
			
			System.out.println("\n");
			System.out.println("Where First Name = Mika");
			employees = session.createQuery("FROM Employee WHERE firstName='Mika'").getResultList(); 
			getResults(employees);
			
			System.out.println("\n");
			System.out.println("Where company = Self Employed");
			employees = session.createQuery("FROM Employee WHERE company='Self Employed'").getResultList();
			getResults(employees);
			
			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

	private static void getResults(List<Employee> employees) {
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
}
