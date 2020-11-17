import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateCourse {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int courseId = 9;

            session = factory.getCurrentSession();
            session.beginTransaction();


            Course course = (Course) session.get(Course.class, courseId);

            course.setTitle("History of worlds");

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();


            session.createQuery("update Course set title='a book title' where id = 8")
                    .executeUpdate();

            session.getTransaction().commit();


            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

}
