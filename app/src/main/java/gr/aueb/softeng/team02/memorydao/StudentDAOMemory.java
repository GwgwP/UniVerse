package gr.aueb.softeng.team02.memorydao;

import java.util.HashSet;

import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.model.Student;
import gr.aueb.softeng.team02.model.User;

public class StudentDAOMemory implements StudentDAO {

    HashSet<Student> entities = new HashSet<>();

    @Override
    public HashSet<Student> findAll() {
        return entities;
    }

    @Override
    public Student findStudent(String username, String password) {
        for (Student student : this.entities) {
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
