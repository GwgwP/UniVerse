package gr.aueb.softeng.team02.model.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Set;

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
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Grade;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.model.Student;
import gr.aueb.softeng.team02.model.Subject;

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
        // Find All
        Assert.assertEquals(studentDAO.findAll().size(), 4);

        // FindStudentByUserAndPassword
        Assert.assertEquals(studentDAO.findStudentByUsernameAndPassword("p3200199", "Link").getName(), "Panagiotis");
        Assert.assertNull(studentDAO.findStudentByUsernameAndPassword("icndiw", "ksjfu"));

        // FindSemesterOfStudent
        Assert.assertEquals(studentDAO.findSemesterOfStudent(3200125), 6);
        Assert.assertEquals(studentDAO.findSemesterOfStudent(38481100), 0);

        // FindStudentById
        Assert.assertEquals(studentDAO.findStudentById(3200199).getName(), "Panagiotis");
        Assert.assertNull(studentDAO.findStudentById(801274));

        Assert.assertEquals(studentDAO.findStudentById(3200125), new Student(3200125, "p3200125", "Irma", "Lydia-Christina", "Wallace", 6));

        Set<Student> set = studentDAO.findAll();
        boolean flag = set.contains(new Student(3200125, "p3200125", "Irma", "Lydia-Christina", "Wallace", 6));
        Assert.assertTrue(studentDAO.findAll().contains(new Student(3200125, "p3200125", "Irma", "Lydia-Christina", "Wallace", 6)));
        // save
        studentDAO.save(new Student(3200125, "p3200125", "Irma", "Lydia-Christina", "Wallace", 6));
        Assert.assertEquals(studentDAO.findAll().size(), 4);
        studentDAO.save(new Student(3200148, "p3200148", "Diablo", "Dimitris-Patapios", "Pararas", 6));
        Assert.assertEquals(studentDAO.findAll().size(), 5);

        // delete
        studentDAO.delete(new Student(7200219, "l7200219", "Ocarina", "Kostis", "Triantafillidis", 6));
        Assert.assertEquals(studentDAO.findAll().size(), 5);
        studentDAO.delete(new Student(3200148, "p3200148", "Diablo", "Dimitris-Patapios", "Pararas", 6));
        Assert.assertEquals(studentDAO.findAll().size(), 4);
    }

    @Test
    public void TestAcademicYear() throws AcademicYearException {
        // save
        AcademicYear year = new AcademicYear();
        year.setAc_year("2025-2026");
        academicYearDAO.save(year);
        Assert.assertEquals(academicYearDAO.findAll().size(), 3);

        AcademicYear year1 = new AcademicYear();
        year1.setAc_year("2021-2022");
        academicYearDAO.save(year1);
        Assert.assertEquals(academicYearDAO.findAll().size(), 3);

        // delete
        AcademicYear year2 = new AcademicYear();
        year2.setAc_year("2025-2026");
        academicYearDAO.delete(year2);
        Assert.assertEquals(academicYearDAO.findAll().size(), 2);

        AcademicYear year3 = new AcademicYear();
        year3.setAc_year("2025-2026");
        academicYearDAO.delete(year3);
        Assert.assertEquals(academicYearDAO.findAll().size(), 2);

        // find
        Assert.assertEquals(academicYearDAO.find("2021-2022"), year1);
        Assert.assertNull(academicYearDAO.find("2025-2026"));

        // findAll
        Assert.assertEquals(academicYearDAO.findAll().size(), 2);

        // findVCircumscription
        Assert.assertEquals(academicYearDAO.findCircumscriptionBySemesterAndYear(6, "2021-2022").getEcts(), 30);
        Assert.assertNull(academicYearDAO.findCircumscriptionBySemesterAndYear(1, "2025-2026"));
        academicYearDAO.save(year);
        Assert.assertThrows(AcademicYearException.class, () -> {
            academicYearDAO.findCircumscriptionBySemesterAndYear(6, "2025-2026");
        });

        // get & set current academic year
        LocalDate dateOdd2023 = LocalDate.of(2023, 2, 28);
        LocalDate dateEven2023 = LocalDate.of(2023, 6, 1);
        academicYearDAO.setCurrentAcadYear(new AcademicYear("2022-2023", dateEven2023, dateOdd2023));
        AcademicYear y = new AcademicYear();
        y.setAc_year("2022-2023");
        Assert.assertEquals(academicYearDAO.getCurrentAcadYear(), y);
    }

    @Test
    public void TestGrade() {
        // save
        Subject su1 = new Subject("Stauros Toumpis", 8, "Advanced Mathematics", "Algebra 1");
        LocalDate dateOdd2022 = LocalDate.of(2022, 2, 28);
        LocalDate dateEven2022 = LocalDate.of(2022, 8, 1);
        AcademicYear y1 = new AcademicYear("2021-2022", dateEven2022, dateOdd2022);
        OfferedSubject o1 = new OfferedSubject(1, su1, y1);
        Student s1 = new Student(3200125, "p3200125", "Irma", "Lydia-Christina", "Wallace", 6);
        Grade g1 = new Grade(s1, o1, 8);
        gradeDAO.save(g1);
        Assert.assertEquals(gradeDAO.findAll().size(), 15);

        Subject su29 = new Subject("Bill Zafeirhs", 8, "Introduction on Web technologies and programming", " Web Development");
        OfferedSubject o29 = new OfferedSubject(1, su29, y1);
        Student s2 = new Student(3200125, "p3200125", "Irma", "Lydia-Christina", "Wallace", 6);
        Grade g2 = new Grade(s2, o29, 8);
        gradeDAO.save(g2);
        Assert.assertEquals(gradeDAO.findAll().size(), 16);

        // delete
        gradeDAO.delete(g2);
        Assert.assertEquals(gradeDAO.findAll().size(), 15);

        gradeDAO.delete(g2);
        Assert.assertEquals(gradeDAO.findAll().size(), 15);

        // findAll
        Set<Grade> grades = gradeDAO.findAll();
        Assert.assertEquals(gradeDAO.findAll().size(), 15);

        // findPassedSubjectsByStudent
        Assert.assertEquals(gradeDAO.findPassedSubjectsByStudent(3200125).size(), 10);

        // findBySubject
        Assert.assertEquals(gradeDAO.findBySubject("Algebra 1", 3200125).getGrade(), 8);
        Assert.assertNull(gradeDAO.findBySubject("Multimedia technology", 3200125));

        // findBySemesterAndSubjects
        Assert.assertEquals(gradeDAO.findBySemesterSubjects(3200125, 1).size(), 5);

        // FindByStudent
        Assert.assertEquals(gradeDAO.findByStudent(3200199).size(), 0);
        Assert.assertEquals(gradeDAO.findByStudent(3200125).size(), 10);
    }

    @Test
    public void TestOfferedSubject() {
        // save

        // delete

        // findAll

        // findByModulo

        // findByYearAndName

        // findAllSubjectsByYearAndBySemester

        // findByYear

        // findByTitle

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
