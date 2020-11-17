import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateInstructor {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            int instructorId = 1;
            Instructor instructor = (Instructor) session.get(Instructor.class, instructorId);

            instructor.setEmail("updatedEmail@yahoo");

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Instructor set firstName ='AAAA' where id = 1")
                    .executeUpdate();
            session.createQuery("update Instructor set instructorDetail=1 where id=1").executeUpdate();

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }
}
