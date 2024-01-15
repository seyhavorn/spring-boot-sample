package com.seyhavorn.demo.rest;

import com.seyhavorn.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("student")
    public List<Student> getStudents() {
        List<Student> theStudent = new ArrayList<>();

        theStudent.add(new Student("Seyha", "Vorn"));
        //theStudent.add(new )

        return theStudent;
    }
}
