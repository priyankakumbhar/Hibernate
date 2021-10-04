package com.hibernate.cruddemo;
import com.utils.DateUtils;

import java.sql.SQLSyntaxErrorException;
import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetails;
import com.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory =new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		
		try
		{
			;
			
			//start transaction
			session.beginTransaction();
			
			//get instructor object with id
			int id=1;
			Instructor instructor=session.get(Instructor.class, id);
			
			//create courses object
			Course course = new Course("Football");
			Course course1 = new Course("Cricket");		
			
			//associate courses with instructor
			instructor.add(course);
			instructor.add(course1);
			
			//save instructor object
			session.save(course);
			session.save(course1);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally
		{
			session.close();
			factory.close();
		}

	}

}
