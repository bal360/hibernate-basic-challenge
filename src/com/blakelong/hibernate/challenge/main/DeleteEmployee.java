package com.blakelong.hibernate.challenge.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blakelong.hibernate.challenge.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {
		
		// create factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// primary key to delete
			int employeeId = 1;
			
			// begin transaction
			session.beginTransaction();
			
			// get employee
			Employee employee = session.get(Employee.class, employeeId);
			
			// delete employee
			session.delete(employee);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
		
	}
}
