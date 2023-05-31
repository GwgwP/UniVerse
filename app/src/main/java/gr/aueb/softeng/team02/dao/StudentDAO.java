package gr.aueb.softeng.team02.dao;
import java.util.HashSet;

import gr.aueb.softeng.team02.model.*;
import gr.aueb.softeng.team02.model.Student;

public interface StudentDAO {
    public HashSet<Student> findAll();
    public Student findStudentByUsernameAndPassword(String username, String password);
    public Student findStudentById(int id);
    public void save(Student student);
    public void delete(Student student);
}
