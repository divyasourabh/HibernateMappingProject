package com.ds.hibernate.app.one2one.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ds.hibernate.entity.Instructor;
import com.ds.hibernate.entity.InstructorDetail;

public class One2OneMappingDeleteDemoApp {
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
			int id =1;
			
			// start a transaction
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, id);
					

//			****************************************
//			Note: this will ALSO Delete the details Object
//			because of CascadeType ALL
//			***************************
			
			if (instructor != null) {
				session.delete(instructor);
			}
// commit transaction

			session.getTransaction().commit();

			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
}
