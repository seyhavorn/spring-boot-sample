package com.seyhavorn.cruddemo.dao;

import com.seyhavorn.cruddemo.entity.Instructor;
import com.seyhavorn.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);
}
