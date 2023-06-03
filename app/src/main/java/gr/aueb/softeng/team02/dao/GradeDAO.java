package gr.aueb.softeng.team02.dao;

import java.util.Set;

import gr.aueb.softeng.team02.model.*;

public interface GradeDAO {
    public Set<Grade> findByStudent(int studentId);

    public Grade findBySubject(String title, int studentId);

    public Set<Grade> findPassedSubjectsByStudent(int studentId);

    public void save(Grade entity);

    public void delete(Grade entity);

    public Set<Grade> findAll();

    public Set<Grade> findBySemesterSubjects(int id, int semester);

}
