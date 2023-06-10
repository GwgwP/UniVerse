package gr.aueb.softeng.team02.memorydao;

import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.model.Student;

public class StudentDAOMemory implements StudentDAO {

    private static HashSet<Student> entities = new HashSet<>();

    /**
     * Get a set of all students in the dao
     *
     * @return a set of student objects
     */
    @Override
    public Set<Student> findAll() {
        return new HashSet<>(entities);
    }

    /**
     * Get a student based on the username and password
     *
     * @param username username of the student as string
     * @param password password of the student as string
     * @return a student object or null
     */
    @Override
    public Student findStudentByUsernameAndPassword(String username, String password) {
        // Log.e("DEBUGGER", "here");
        for (Student student : entities) {
            // Log.e("DEBUGGER", student.getUsername());
            if (student.getUsername().equals(username) && student.getPassword().equals(password))
                return student;
        }
        return null;
    }

    /**
     * Get the semester of a student based on the id
     *
     * @param student_id the id of the student
     * @return the semester of the student or 0 ( zero is not a valid semester )
     */
    @Override
    public int findSemesterOfStudent(int student_id) {
        for (Student student : entities) {
            if (student.getId() == student_id) {
                return student.getSemester();
            }
        }
        // No Subject
        return 0;
    }

    /**
     * Get the student based on the student id
     *
     * @param id the id of the student
     * @return a student object or null
     */
    @Override
    public Student findStudentById(int id) {
        for (Student student : entities) {
            if (student.getId() == id)
                return student;
        }
        return null;
    }

    /**
     * Save the student if it doesn't exist in the dao
     *
     * @param student the student object
     */
    @Override
    public void save(Student student) {
        entities.add(student);
    }

    /**
     * Delete the student if it does exist in the dao
     *
     * @param student student object or null
     */
    @Override
    public void delete(Student student) {
        entities.remove(student);
    }
}
