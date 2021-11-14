package sk.kasv.mizak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kasv.mizak.hibernate.demo.entity.Student;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {
            System.out.println("creating new Student obj");
            Student student=new Student("Richard","Mizak","mizak@gmail.com");
            session.beginTransaction();
            System.out.println("saving student");
            session.save(student);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
