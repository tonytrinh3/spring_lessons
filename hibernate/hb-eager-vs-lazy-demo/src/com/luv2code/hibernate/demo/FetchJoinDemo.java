package com.luv2code.hibernate.demo;

import com.luv2code.entity.Course;
import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

    public static void main(String[] args){
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try{
            //use the session object to save java object

            //start a transaction
            session.beginTransaction();

            //option 2: Hibernate query with HQL

            //get the instructor from db
            int theId = 1;

            //join fetch
            //https://docs.jboss.org/hibernate/orm/5.3/javadocs/org/hibernate/Query.html
            Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId", Instructor.class);

            //set parameter on query

            query.setParameter("theInstructorId", theId);

            //execute query and get instructor
            //load instructor and courses all at once
            Instructor tempInstructor = query.getSingleResult();
            System.out.println("luv2code: Instructor: " + tempInstructor);

            //commit transaction 
            session.getTransaction().commit();

            //close the session
            session.close();


            //close the session
            session.close();

            System.out.println("\nluv2code: The session is now closed!\n");

            //option 1: call getter method while session is open


            //get courses for the instructor
            // executed after session closed but it is using the same data that was loaded before session closed so this was able to work
            // bc the data was fetched and stored in local cache

            System.out.println("luv2code: 2Courses: " + tempInstructor.getCourses());

            System.out.println("luv2code: Done!");


        } finally{
            //add clean up code
            session.close(); //to deal with leak in case something doesn't work
            factory.close();
        }

    }
}
