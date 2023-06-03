package gr.aueb.softeng.team02.memorydao;

import java.util.HashSet;
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
import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;

public class MemoryInitializer extends Initializer {
    public MemoryInitializer() {
        System.setProperty("daofactory", "gr.aueb.softeng.team02.memorydao.MemoryDAOFactory");
    }

    @Override
    protected void eraseData() {
        Set<Student> allStudents = getStudentDAO().findAll();
        for (Student student : allStudents)
            getStudentDAO().delete(student);

        Set<Secretary> allSecretaries = getSecretaryDAO().findAll();
        for (Secretary secretary : allSecretaries)
            getSecretaryDAO().delete(secretary);
    }

    @Override
    public SecretaryDAO getSecretaryDAO() {
        return DAOFactory.getFactory().getSecretaryDAO();
    }

    @Override
    public StudentDAO getStudentDAO() {
        return DAOFactory.getFactory().getStudentDAO();
    }

    @Override
    public AcademicYearDAO getAcademicYearDAO() {
        return DAOFactory.getFactory().getAcademicYearDAO();
    }

    @Override
    public OfferedSubjectDAO getOfferedSubjectDAO() {
        return DAOFactory.getFactory().getOfferedSubjectDAO();
    }

    @Override
    public SubjectDAO getSubjectDAO() {
        return DAOFactory.getFactory().getSubjectDAO();
    }

    @Override
    public SubmissionDAO getSubmissionSAO() {
        return DAOFactory.getFactory().getSubmissionDAO();
    }

    @Override
    public GradeDAO getGradeDAO() {
        return DAOFactory.getFactory().getGradeDAO();
    }
}
