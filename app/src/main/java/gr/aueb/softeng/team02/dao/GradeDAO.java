package gr.aueb.softeng.team02.dao;

import java.util.Set;

import gr.aueb.softeng.team02.model.*;

public interface GradeDAO {
    /**
     * Get a set of grades based on the id of a student
     *
     * @param studentId student id integer, a unique key for Student objects
     * @return set of grades
     */
    public Set<Grade> findByStudent(int studentId);

    /**
     * Get grade based on the title of the subject and the student id
     *
     * @param title     the title of the subject as a string
     * @param studentId the student id as an integer
     * @return
     */
    public Grade findBySubject(String title, int studentId);

    /**
     * Get a set of grades based on the id of a student
     *
     * @param studentId the id of a student as an integer
     * @return a set of grades
     */
    public Set<Grade> findPassedSubjectsByStudent(int studentId);

    /**
     * Save the grade if it doesn't exist
     *
     * @param entity
     */
    public void save(Grade entity);

    /**
     * Delete a specific Grade if it already exists
     *
     * @param entity the grade that may be deleted
     */
    public void delete(Grade entity);

    /**
     * Get all grades
     *
     * @return a set of grades
     */
    public Set<Grade> findAll();

    /**
     * Get a set of grades based on the id of a student and the semester of the offered subject
     *
     * @param id       student id as an integer
     * @param semester the semester of the offered subject as an integer
     * @return a set of grades
     */
    public Set<Grade> findBySemesterSubjects(int id, int semester);

}
