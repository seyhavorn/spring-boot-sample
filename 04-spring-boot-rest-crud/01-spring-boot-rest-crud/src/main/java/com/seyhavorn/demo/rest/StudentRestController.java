package com.seyhavorn.demo.rest;

import com.seyhavorn.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudent;

    @PostConstruct
    public void loadDate() {
        theStudent = new ArrayList<>();

        theStudent.add(new Student("Seyha", "Vorn"));
        theStudent.add(new Student("Srey", "Sart"));
        theStudent.add(new Student("Seyha1", "Vorn1"));
    }

    //defind endpoint for "/student"
    @GetMapping("student")
    public List<Student> getStudents() {
        return theStudent;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        //Just index into the list... keep it simple for now

        //check the studentId again list size:
        if ((studentId >= theStudent.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudent.get(studentId);
    }
}
