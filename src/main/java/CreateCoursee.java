import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursee {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            // create the objects

            System.out.println("Creating new instructor object...");
            Course tempCourse =
                    new Course("Delete this course");

            Instructor tempInstructor =
                    new Instructor("Delete","this", "too@please.lol");

            tempCourse.setInstructor(tempInstructor);
            InstructorDetail instDet = new InstructorDetail("hello@utube.yv", "playing bball");
            tempInstructor.setInstructorDetail(instDet);
            session.beginTransaction();

            System.out.println("Saving course: " + tempCourse);
            session.save(tempCourse);
            session.save(tempInstructor);
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

}
