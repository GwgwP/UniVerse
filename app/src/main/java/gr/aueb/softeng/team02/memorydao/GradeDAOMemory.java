package gr.aueb.softeng.team02.memorydao;

import android.util.Log;

import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.model.Grade;

import java.util.HashSet;
import java.util.Set;


public class GradeDAOMemory implements GradeDAO {

    protected static HashSet<Grade> entities = new HashSet<Grade>();

    @Override
    public Set<Grade> findByStudent(int studentId) {
        HashSet<Grade> studentGrades = new HashSet<Grade>();
        for (Grade grade : entities) {
            if (grade.getStudentId() == studentId) {
                studentGrades.add(grade);
            }
        }
        return studentGrades;
    }

    @Override
    public Set<Grade> findBySemesterSubjects(int id, int semester)
    {
        HashSet<Grade> studentGradesBySem = new HashSet<Grade>();
        for (Grade g:entities)
        {
            if(g.getStudentId() == id && g.getSemester() == semester)
            {

                studentGradesBySem.add(g);
            }
        }
        return studentGradesBySem;
    }


    @Override
    public Grade findBySubject(String title, int studentId) {
        for (Grade grade : entities) {
            if (grade.getStudentId() == studentId && grade.getTitle().equals(title)) {
                return grade;
            }
        }
        return null;
    }

    @Override
    public Set<Grade> findPassedSubjectsByStudent(int studentId) {
        HashSet<Grade> gradings = new HashSet<>();
        for (Grade g : entities) {
            if (g.getGrade() >= 5 && g.getStudentId() == studentId) {
                gradings.add(g);
            }
        }
        return gradings;
    }

    @Override
    public void save(Grade entity) {
        if (!entities.contains(entity))
            entities.add(entity);
    }

    @Override
    public void delete(Grade entity) {
        if (entities.contains(entity))
            entities.add(entity);
    }

    @Override
    public Set<Grade> findAll() {
        return new HashSet<>(entities);
    }
}
