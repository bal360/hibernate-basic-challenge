package com.blakelong.hibernate.challenge.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blakelong.hibernate.challenge.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		
		// create factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			// create a student
			System.out.println("Creating a new employee");
			
			Employee blake = new Employee("Blake", "Long", "Flatiron");
			Employee wes = new Employee("Wes", "Kenneth", "Self Employed");
			Employee john = new Employee("Juan", "Long", "THC Buyer");
			Employee susan = new Employee("Susan", "Studebaker", "Retired");
			Employee mika = new Employee("Mika", "Long", "Baby&Co");
			
			// begin transaction
			session.beginTransaction();
			
			// save the objects
			session.save(blake);
			session.save(wes);
			session.save(john);
			session.save(susan);
			session.save(mika);
			
			// commit objects - persist to db
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

}
