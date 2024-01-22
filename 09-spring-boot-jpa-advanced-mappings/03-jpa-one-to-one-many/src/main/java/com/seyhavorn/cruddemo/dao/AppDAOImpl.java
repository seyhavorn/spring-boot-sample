package com.seyhavorn.cruddemo.dao;

import com.seyhavorn.cruddemo.entity.Course;
import com.seyhavorn.cruddemo.entity.Instructor;
import com.seyhavorn.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    //define: field for entity manager:

    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        //retrieve instructor:
        Instructor tmplInstructor = entityManager.find(Instructor.class, theId);

        List<Course> courses = tmplInstructor.getCourses();
        for (Course tmpCourse : courses) {
            tmpCourse.setInstructor(null);
        }

        entityManager.remove(tmplInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        //remove the associated object reference
        //break bi-directional link

        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCourseByInstructorId(int theId) {
        //create query
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class
        );

        query.setParameter("data", theId);
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        //create query:
        TypedQuery<Instructor> query = entityManager.createQuery(
                "SELECT i from Instructor i "
                        + "JOIN FETCH i.courses "
                        + "JOIN FETCH i.instructorDetail "
                        + "WHERE i.id = :data", Instructor.class
        );

        query.setParameter("data", theId);

        //execute query:
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor tmpInstructor) {
        entityManager.merge(tmpInstructor);
    }

    @Override
    @Transactional
    public void update(Course tmpCourse) {
        entityManager.merge(tmpCourse);
    }

    @Override
    public Course findCourseByIf(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override

    @Transactional
    public void deleteCourseById(int theId) {
        //Finding course:
        Course tmpCourse = entityManager.find(Course.class, theId);

        //delete course:
        entityManager.remove(tmpCourse);
    }
}
