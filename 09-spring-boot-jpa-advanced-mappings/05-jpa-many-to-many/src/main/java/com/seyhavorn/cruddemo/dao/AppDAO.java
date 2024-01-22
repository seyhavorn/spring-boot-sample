package com.seyhavorn.cruddemo.dao;

import com.seyhavorn.cruddemo.entity.Course;
import com.seyhavorn.cruddemo.entity.Instructor;
import com.seyhavorn.cruddemo.entity.InstructorDetail;
import com.seyhavorn.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCourseByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tmpInstructor);

    void update(Course tmpCourse);

    Course findCourseByIf(int theId);

    void deleteCourseById(int theId);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentByCourseId(int theId);

    Student findStudentAndCourseByStudentId(int theId);

    void update(Student tmpStudent);

    void deleteStudentById(int theId);
}
