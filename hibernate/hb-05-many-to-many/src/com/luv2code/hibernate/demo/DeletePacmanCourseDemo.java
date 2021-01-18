package com.luv2code.hibernate.demo;

import com.luv2code.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourseDemo {

    public static void main(String[] args){
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try{
            //use the session object to save java object

            //start a transaction
            session.beginTransaction();

            //get the pacman course from db
            int courseId = 10;
            Course tempCourse = session.get(Course.class,courseId);

            //delete the course
            System.out.println("Deleting course: "+ tempCourse);

            session.delete(tempCourse);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");


        } finally{
            //add clean up code
            session.close(); //to deal with leak in case something doesn't work
            factory.close();
        }

    }
}
