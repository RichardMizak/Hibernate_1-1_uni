package sk.kasv.mizak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kasv.mizak.hibernate.demo.entity.Instructor;
import sk.kasv.mizak.hibernate.demo.entity.InstructorDetail;
import sk.kasv.mizak.hibernate.demo.entity.Student;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {

           /* Instructor instructor=new Instructor("Richard","Mizak","mizak@gmail.com");

            InstructorDetail instructorDetail=new InstructorDetail("http://www.youtube.com/mizak","luv 2 code");

            instructor.setInstructorDetail(instructorDetail);*/
           Instructor instructor=new Instructor("Scott","Pilgrim","pilgrim@gmail.com");

           InstructorDetail instructorDetail=new InstructorDetail("http://www.youtube.com/pilgrim","guitar");

           instructor.setInstructorDetail(instructorDetail);

           session.beginTransaction();
            System.out.println("Saving instructor: "+instructor);
           session.save(instructor);

           session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
