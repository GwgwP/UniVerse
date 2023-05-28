package gr.aueb.softeng.team02.dao;
import java.util.HashSet;

import gr.aueb.softeng.team02.model.*;

public interface StudentDAO {
    public HashSet<Student> findAll();
    public Student findStudent(String username, String password);
    public void save(Student student);
    public void delete(Student student);
}
