import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadInstructor {
    public static void main(String[] args) {


    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .buildSessionFactory();
     try {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        int instructorId = 4;
        Instructor instructor = (Instructor) session.get(Instructor.class, instructorId);
        System.out.println("Instructor: " + instructor);
        session.getTransaction().commit();
    }finally {
        factory.close();
    }
}
}
