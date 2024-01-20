package com.seyhavorn.cruddemo;

import com.seyhavorn.cruddemo.dao.AppDAO;
import com.seyhavorn.cruddemo.entity.Instructor;
import com.seyhavorn.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            //createInstructor(appDAO);
            //findInstructor(appDAO);
            deleteInstructor(appDAO);
        };
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
