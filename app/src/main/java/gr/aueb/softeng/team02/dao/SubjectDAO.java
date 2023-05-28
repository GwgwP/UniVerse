package gr.aueb.softeng.team02.dao;

import gr.aueb.softeng.team02.model.Subject;
import java.util.*;

public interface SubjectDAO {
    public List<Subject> findAll();
    public Subject findSubject(String title);
    public void save(Subject subject);
    public void delete(Subject subject);
    public int nextId();
}
