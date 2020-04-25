package com.ds.hibernate.app.one2one.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ds.hibernate.entity.Instructor;
import com.ds.hibernate.entity.InstructorDetail;
import com.ds.hibernate.entity.InstructorDetailBiDirectional;

public class BiDirectionMappingDemoApp {
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
			
		
			
			// start a transaction
			session.beginTransaction();

			int id = 5;
			InstructorDetail instructorDetailBiDirectional = session.get(InstructorDetail.class,id);
			
			System.out.println("instructorDetail= " + instructorDetailBiDirectional);
			
			System.out.println("Instructor= " + instructorDetailBiDirectional.getInstructor());
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
}
