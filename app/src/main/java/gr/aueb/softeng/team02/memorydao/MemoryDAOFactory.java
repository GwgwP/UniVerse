package gr.aueb.softeng.team02.memorydao;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.DAOFactory;
import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.dao.SecretaryDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.dao.SubmissionDAO;

public class MemoryDAOFactory extends DAOFactory {
    private StudentDAOMemory studentDAOMemory = new StudentDAOMemory();
    private SecretaryDAOMemory secretaryDAOMemory = new SecretaryDAOMemory();
    private AcademicYearDAOMemory academicYearDAOMemory = new AcademicYearDAOMemory();
    private SubjectDAOMemory subjectDAOMemory = new SubjectDAOMemory();
    private GradeDAOMemory gradeDAOMemory = new GradeDAOMemory();
    private OfferedSubjectDAOMemory offeredSubjectDAOMemory = new OfferedSubjectDAOMemory();
    private SubmissionDAOMemory submissionDAOMemory = new SubmissionDAOMemory();
    @Override
    public StudentDAO getStudentDAO() {
        return studentDAOMemory;
    }

    @Override
    public SecretaryDAO getSecretaryDAO() {
        return secretaryDAOMemory;
    }

    @Override
    public AcademicYearDAO getAcademicYearDAO() {
        return academicYearDAOMemory;
    }

    @Override
    public SubjectDAO getSubjectDAO() {
        return subjectDAOMemory;
    }

    @Override
    public GradeDAO getGradeDAO() {
        return gradeDAOMemory;
    }

    @Override
    public OfferedSubjectDAO getOfferedSubjectDAO() {
        return offeredSubjectDAOMemory;
    }

    @Override
    public SubmissionDAO getSubmissionDAO() {
        return submissionDAOMemory;
    }
}
