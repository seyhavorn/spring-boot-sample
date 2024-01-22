package com.seyhavorn.cruddemo;

import com.seyhavorn.cruddemo.dao.AppDAO;
import com.seyhavorn.cruddemo.entity.Course;
import com.seyhavorn.cruddemo.entity.Instructor;
import com.seyhavorn.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {

        };
    }

    private void deleteCourse(AppDAO appDAO) {
        int theId = 10;

        System.out.println("Deleting Course with id: " + theId);

        appDAO.deleteCourseById(theId);

        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO) {
        int theId = 10;

        System.out.println("Finding the Course with Id: " + theId);
        Course tmpCourse = appDAO.findCourseByIf(theId);

        System.out.println("updating Course Id: " + theId);
        System.out.println("Course : " + tmpCourse);
        tmpCourse.setTitle("Enjoy the Holiday!");

        appDAO.update(tmpCourse);
    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding the Instructor Id: " + theId);

        //finding instructor:
        Instructor tmpInstructor = appDAO.findInstructorById(theId);
        System.out.println("Updating instructor Id: " + theId);
        tmpInstructor.setLastName("Cheat");

        //Update the instructor:
        appDAO.update(tmpInstructor);
        System.out.println("Done!");
    }

    private void findInstructorWithCoursesJointFetch(AppDAO appDAO) {
        int theId = 1;
        //Finding instructor:
        System.out.println("Finding the instructor with ID: " + theId);

        Instructor tmpInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("Instructor " + tmpInstructor);

        System.out.println("the associate courses " + tmpInstructor.getCourses());
        System.out.println("Done!");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;
        //Finding instructor:
        System.out.println("Finding the instructor with ID: " + theId);

        Instructor tmpInstructor = appDAO.findInstructorById(theId);

        System.out.println("Instructor " + tmpInstructor);

        //Find course for instructor:
        System.out.println("Finding Courses for instructor Id: " + theId);
        List<Course> courses = appDAO.findCourseByInstructorId(theId);

        //associate the Object:
        tmpInstructor.setCourses(courses);

        System.out.println("Instructor associate " + tmpInstructor.getCourses());
        System.out.println("Done!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding the instructor with ID: " + theId);

        Instructor tmpInstructor = appDAO.findInstructorById(theId);

        System.out.println("Instructor " + tmpInstructor);

        System.out.println("Instructor associate " + tmpInstructor.getCourses());
        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor("Seyha", "Vorn", "seyhavotn1@gmail.com");

        //create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("Seyha Vorn", "Guitar Playing.");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        //create some courses:
        Course tmpCourses1 = new Course("The Ultimate Guitar");
        Course tmpCourses2 = new Course("The Ultimate Design");

        //add courses to instructor
        tempInstructor.add(tmpCourses1);
        tempInstructor.add(tmpCourses2);

        //save the instructor:
        // NOTE: will also save the courses
        // because of: CascadeType.PERSIST
        System.out.println("saving the instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    private void deleteInstructorDetailById(AppDAO appDAO) {
        int theId = 3;

        System.out.println("Deleting Instructor Detail id: " + theId);

        appDAO.deleteInstructorDetailById(theId);

        System.out.println("Done!");
    }

    private void findInstructorDetailById(AppDAO appDAO) {
        //get instructor detail object
        int theId = 2;
        InstructorDetail tmpInstructorDetail = appDAO.findInstructorDetailById(theId);

        // print the instructor detail
        System.out.println("Instructor Detail: " + tmpInstructorDetail.getInstructor());

        //print the associate instructor
        System.out.println("Done!");
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting Instructor id: " + theId);
        appDAO.deleteInstructorById(theId);
        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 2;
        System.out.println("Finding Instructor Id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("Instructor: " + tempInstructor);
        System.out.println("The associated InstructorDetail Only : " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
        //create the instructor:

        Instructor tempInstructor = new Instructor("seyha1", "vorn1", "seyhavotn1@gmail.com");

        //create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("Seyha Vorn", "Guitar Playing.");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        //save the instructor
        //
        // NOTE: this will ALSO sve the details object
        // because of CascadeType.ALL
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Done!");
    }

}
