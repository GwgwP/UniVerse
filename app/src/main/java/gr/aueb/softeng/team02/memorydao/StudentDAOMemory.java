package gr.aueb.softeng.team02.memorydao;

import android.util.Log;

import java.util.HashSet;

import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.model.Student;

public class StudentDAOMemory implements StudentDAO {

    private static HashSet<Student> entities = new HashSet<>();

    @Override
    public HashSet<Student> findAll() {
        return new HashSet<>(entities);
    }

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

    @Override
    public Student findStudentById(int id) {
        for (Student student : entities) {
            if (student.getId() == id)
                return student;
        }
        return null;
    }

    @Override
    public void save(Student entity) {
        if (! entities.contains(entity))
            entities.add(entity);
    }

    @Override
    public void delete(Student entity) {
        if (entities.contains(entity))
            entities.remove(entity);
    }
}
