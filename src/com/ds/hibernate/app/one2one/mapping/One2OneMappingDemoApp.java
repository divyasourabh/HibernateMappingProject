package com.ds.hibernate.app.one2one.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ds.hibernate.entity.Instructor;
import com.ds.hibernate.entity.InstructorDetail;

public class One2OneMappingDemoApp {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
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
