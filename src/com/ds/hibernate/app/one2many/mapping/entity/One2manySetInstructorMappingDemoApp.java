package com.ds.hibernate.app.one2many.mapping.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class One2manySetInstructorMappingDemoApp {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate_one2many.cfg2.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {			
			
			Instructor instructor = new Instructor("Divya", "Sourabh", "divyasourabh@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("youtube channel url", "Reading");
			
			instructor.setInstructorDetail(instructorDetail);

			Instructor instructor1 = new Instructor("Sourabh", "DIvya", "divyasourabh@gmail.com");
			
			InstructorDetail instructorDetail1 = new InstructorDetail("youtube channel url", "Coding");
			
			instructor1.setInstructorDetail(instructorDetail1);
			
			
			// start a transaction
			session.beginTransaction();

//			****************************************
//			Note: this will ALSO save the details Object
//			because of CascadeType ALL
//			***************************
			
			
			session.save(instructor);
			session.save(instructor1);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
}
