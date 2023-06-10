package gr.aueb.softeng.team02.memorydao;

import android.util.Log;

import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.model.Grade;

import java.util.HashSet;
import java.util.Set;


public class GradeDAOMemory implements GradeDAO {

    protected static HashSet<Grade> entities = new HashSet<Grade>();

    /**
     * Get a set of grades based on the id of a student
     *
     * @param studentId student id integer, a unique key for Student objects
     * @return set of grades
     */
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

    /**
     * Get a set of grades based on the id of a student and the semester of the offered subject
     *
     * @param id       student id as an integer
     * @param semester the semester of the offered subject as an integer
     * @return a set of grades
     */
    @Override
    public Set<Grade> findBySemesterSubjects(int id, int semester) {
        HashSet<Grade> studentGradesBySem = new HashSet<Grade>();
        for (Grade g : entities) {
            if (g.getStudentId() == id && g.getSemester() == semester) {

                studentGradesBySem.add(g);
            }
        }
        return studentGradesBySem;
    }

    /**
     * Get grade based on the title of the subject and the student id
     *
     * @param title     the title of the subject as a string
     * @param studentId the student id as an integer
     * @return
     */
    @Override
    public Grade findBySubject(String title, int studentId) {
        for (Grade grade : entities) {
            if (grade.getStudentId() == studentId && grade.getTitle().equals(title)) {
                return grade;
            }
        }
        return null;
    }

    /**
     * Get a set of grades based on the id of a student
     *
     * @param studentId the id of a student as an integer
     * @return a set of grades
     */
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

    /**
     * Delete a specific Grade if it already exists
     *
     * @param entity the grade that may be deleted
     */
    @Override
    public void save(Grade entity) {
        entities.add(entity);
    }

    /**
     * Delete a specific Grade if it already exists
     *
     * @param entity the grade that may be deleted
     */
    @Override
    public void delete(Grade entity) {
        entities.remove(entity);
    }

    /**
     * Get all grades
     *
     * @return a set of grades
     */
    @Override
    public Set<Grade> findAll() {
        return new HashSet<>(entities);
    }
}
