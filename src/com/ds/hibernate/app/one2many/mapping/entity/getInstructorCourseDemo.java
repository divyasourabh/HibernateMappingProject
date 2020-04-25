package com.ds.hibernate.app.one2many.mapping.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class getInstructorCourseDemo {

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

			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);		

			System.out.println("Instructor: " + tempInstructor);

			// get courses for the instructor
			System.out.println("Courses: " + tempInstructor.getCourses());

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();

			factory.close();
		}
	}

}





