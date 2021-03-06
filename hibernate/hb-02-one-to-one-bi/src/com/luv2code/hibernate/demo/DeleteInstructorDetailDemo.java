package com.luv2code.hibernate.demo;

import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args){
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try{
            //use the session object to save java object


            //start a transaction
            session.beginTransaction();

            //get the instructor detail object
            int theId = 3;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            //print the instructor detail
            System.out.println("tempInstructorDetail: "+ tempInstructorDetail);

            //print the associated instructor
            System.out.println("the associated instructor: "+ tempInstructorDetail.getInstructor());



            //now let's delete the instructor detail
            System.out.println("Deleting tempInstructorDetail: "+ tempInstructorDetail);

            //remove the associated object reference
            //break bi directional link
            tempInstructorDetail.getInstructor().setInstructorDetail(null); //break 2 way link to Instructor


            session.delete(tempInstructorDetail);



            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");


        } catch (Exception exc) {
            exc.printStackTrace();
        }

        finally{
            //handle connection leak issue
            session.close();
            factory.close();
        }

    }
}
