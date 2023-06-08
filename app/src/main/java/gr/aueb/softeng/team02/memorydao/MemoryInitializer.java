package gr.aueb.softeng.team02.memorydao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.DAOFactory;
import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.dao.SecretaryDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.dao.SubmissionDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.Grade;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;
import gr.aueb.softeng.team02.model.Subject;
import gr.aueb.softeng.team02.model.Submission;

public class MemoryInitializer extends Initializer {
    public MemoryInitializer() {
        System.setProperty("daofactory", "gr.aueb.softeng.team02.memorydao.MemoryDAOFactory");
    }

    /**
     * Erases all the data from the database
     */
    @Override
    protected void eraseData() {
        Set<Student> allStudents = getStudentDAO().findAll();
        for (Student student : allStudents)
            getStudentDAO().delete(student);

        Set<Secretary> allSecretaries = getSecretaryDAO().findAll();
        for (Secretary secretary : allSecretaries)
            getSecretaryDAO().delete(secretary);

        Set<Grade> allGrades = getGradeDAO().findAll();
        for (Grade grade : allGrades)
            getGradeDAO().delete(grade);

        List<OfferedSubject> allOfferedSubjects = getOfferedSubjectDAO().findAll();
        for (OfferedSubject offeredSubject : allOfferedSubjects)
            getOfferedSubjectDAO().delete(offeredSubject);

        Set<AcademicYear> allYears = getAcademicYearDAO().findAll();
        for (AcademicYear year : allYears)
            getAcademicYearDAO().delete(year);

        List<Subject> allSubjects = getSubjectDAO().findAll();
        for (Subject subject : allSubjects)
            getSubjectDAO().delete(subject);

        List<Submission> allSubmissions = getSubmissionDAO().findAll();
        for (Submission submission : allSubmissions)
            getSubmissionDAO().delete(submission);
    }

    /**
     * Get the secretary dao that contains all the secretaries
     *
     * @return the static secretary dao
     */
    @Override
    public SecretaryDAO getSecretaryDAO() {
        return DAOFactory.getFactory().getSecretaryDAO();
    }

    /**
     * Get the student dao that contains all the students
     *
     * @return the static student dao
     */
    @Override
    public StudentDAO getStudentDAO() {
        return DAOFactory.getFactory().getStudentDAO();
    }

    /**
     * Get the academic year dao that contains all the years
     *
     * @return the static academic year dao
     */
    @Override
    public AcademicYearDAO getAcademicYearDAO() {
        return DAOFactory.getFactory().getAcademicYearDAO();
    }

    /**
     * Get the offered subject dao that contains all the offered subjects
     *
     * @return the static offered subject dao
     */
    @Override
    public OfferedSubjectDAO getOfferedSubjectDAO() {
        return DAOFactory.getFactory().getOfferedSubjectDAO();
    }

    /**
     * Get the subject dao that contains all the subjects
     *
     * @return the static subject dao
     */
    @Override
    public SubjectDAO getSubjectDAO() {
        return DAOFactory.getFactory().getSubjectDAO();
    }

    /**
     * Get the submission dao that contains all the submissions
     *
     * @return the static submission dao
     */
    @Override
    public SubmissionDAO getSubmissionDAO() {
        return DAOFactory.getFactory().getSubmissionDAO();
    }

    /**
     * get the grade dao that contains all the grades
     *
     * @return the gstatic grade dao
     */
    @Override
    public GradeDAO getGradeDAO() {
        return DAOFactory.getFactory().getGradeDAO();
    }
}
