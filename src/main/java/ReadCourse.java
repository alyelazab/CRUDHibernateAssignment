import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadCourse {
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
         int courseId = 8;
         Course course = (Course) session.get(Course.class, courseId);
         System.out.println("Course: " + course);
         session.getTransaction().commit();
     }finally {
         factory.close();
     }
    }
}
