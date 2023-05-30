package gr.aueb.softeng.team02.memorydao;

import android.util.Log;

import java.util.HashSet;

import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.model.Student;

public class StudentDAOMemory implements StudentDAO {

    HashSet<Student> entities = new HashSet<>();

    @Override
    public HashSet<Student> findAll() {
        return new HashSet<>(entities);
    }

    @Override
    public Student findStudent(String username, String password) {
        Log.e("DEBUGGER", "here");
        for (Student student : this.entities) {
            Log.e("DEBUGGER", student.getUsername());
            if (student.getUsername().equals(username) && student.getPassword().equals(password))
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
