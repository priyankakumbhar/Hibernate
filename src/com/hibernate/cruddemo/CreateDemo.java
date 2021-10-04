package com.hibernate.cruddemo;
import com.utils.DateUtils;

import java.sql.SQLSyntaxErrorException;
import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetails;
import com.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory =new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		
		try
		{
			
			//create the object
			/*Instructor instructor=new Instructor("Priyanka","kumbhar","priyankakumbhar567@gmail.com");
			
			InstructorDetails instructorDetails=new InstructorDetails("www.love2code.com/youtube","love 2 code!!");
			*/
			//associate objects
			//create the object
			Instructor instructor=new Instructor("shital","raje","shitalraje@gmail.com");
			
			InstructorDetails instructorDetails=new InstructorDetails("www.youtube.com/movie","watch movies");
			
			instructor.setInstructorDetails(instructorDetails);
          
			//start transaction
			session.beginTransaction();
			
			//save Instructor
			// This will also store the details object because of CascadeType = ALL
			
			System.out.println("Saving istructor: "+instructor);
			System.out.println("Saving istructor: "+instructorDetails);
			
			session.save(instructor);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally
		{
			factory.close();
		}

	}

}
