package com.blakelong.hibernate.challenge.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.blakelong.hibernate.challenge.entity.Employee;

public class ReadEmployee {
	
	public static void main(String[] args) {
		
		// create factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// id variable to query for and instantiate object with id
			int employeeId = 1;
			
			// begin transaction
			session.beginTransaction();
			
			// get the employee by id
			Employee employee = session.get(Employee.class, employeeId);
			
			System.out.println("Got student: " + employee);
			
			// commit the transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
