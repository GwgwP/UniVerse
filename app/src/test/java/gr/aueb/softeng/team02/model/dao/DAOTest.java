package gr.aueb.softeng.team02.model.dao;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.dao.SecretaryDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.dao.SubmissionDAO;
import gr.aueb.softeng.team02.memorydao.AcademicYearDAOMemory;
import gr.aueb.softeng.team02.memorydao.GradeDAOMemory;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.memorydao.OfferedSubjectDAOMemory;
import gr.aueb.softeng.team02.memorydao.SecretaryDAOMemory;
import gr.aueb.softeng.team02.memorydao.StudentDAOMemory;
import gr.aueb.softeng.team02.memorydao.SubjectDAOMemory;
import gr.aueb.softeng.team02.memorydao.SubmissionDAOMemory;
import gr.aueb.softeng.team02.model.AcademicYearException;

public class DAOTest {
    private StudentDAO studentDAO;
    private AcademicYearDAO academicYearDAO;
    private GradeDAO gradeDAO;
    private OfferedSubjectDAO offeredSubjectDAO;
    private SecretaryDAO secretaryDAO;
    private SubjectDAO subjectDAO;
    private SubmissionDAO submissionDAO;

    @Before
    public void setUp() throws AcademicYearException {
        Initializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        studentDAO = new StudentDAOMemory();
        academicYearDAO = new AcademicYearDAOMemory();
        gradeDAO = new GradeDAOMemory();
        offeredSubjectDAO = new OfferedSubjectDAOMemory();
        secretaryDAO = new SecretaryDAOMemory();
        subjectDAO = new SubjectDAOMemory();
        submissionDAO = new SubmissionDAOMemory();
    }

    @Test
    public void TestStudent() {

    }

    @Test
    public void TestAcademicYear() {

    }

    @Test
    public void TestGrade() {

    }

    @Test
    public void TestOfferedSubject() {

    }

    @Test
    public void TestSecretary() {

    }

    @Test
    public void TestSubject() {

    }

    @Test
    public void TestSubmission() {

    }
}
