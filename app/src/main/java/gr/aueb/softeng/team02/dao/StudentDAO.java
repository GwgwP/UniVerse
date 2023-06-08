package gr.aueb.softeng.team02.dao;

import java.util.HashSet;
import java.util.Set;

import gr.aueb.softeng.team02.model.*;
import gr.aueb.softeng.team02.model.Student;

public interface StudentDAO {
    /**
     * Get a set of all students in the dao
     *
     * @return a set of student objects
     */
    public Set<Student> findAll();

    /**
     * Get a student based on the username and password
     *
     * @param username username of the student as string
     * @param password password of the student as string
     * @return a student object or null
     */
    public Student findStudentByUsernameAndPassword(String username, String password);

    /**
     * Get the semester of a student based on the id
     *
     * @param student_id the id of the student
     * @return the semester of the student or 0 ( zero is not a valid semester )
     */
    public int findSemesterOfStudent(int student_id);

    /**
     * Get the student based on the student id
     *
     * @param id the id of the student
     * @return a student object or null
     */
    public Student findStudentById(int id);

    /**
     * Save the student if it doesn't exist in the dao
     *
     * @param student the student object
     */
    public void save(Student student);

    /**
     * Delete the student if it does exist in the dao
     *
     * @param student student object or null
     */
    public void delete(Student student);
}
