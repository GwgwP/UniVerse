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
import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;
import gr.aueb.softeng.team02.model.Subject;
import gr.aueb.softeng.team02.model.Submission;

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
        Subject su36 = new Subject("Euagellia Vagena", 8, "Introduction on Elements of law and information", "Elements of law and information");
        LocalDate dateOdd2022 = LocalDate.of(2022, 2, 28);
        LocalDate dateEven2022 = LocalDate.of(2022, 8, 1);
        AcademicYear y1 = new AcademicYear("2021-2022", dateEven2022, dateOdd2022);
        OfferedSubject o36 = new OfferedSubject(8, su36, y1);
        offeredSubjectDAO.save(o36);
        Assert.assertEquals(offeredSubjectDAO.findAll().size(), 72);

        Subject su37 = new Subject("Euagellia Vagena", 8, "Introduction on Security elements", "Security Elements");
        OfferedSubject o37 = new OfferedSubject(8, su37, y1);
        offeredSubjectDAO.save(o37);
        Assert.assertEquals(offeredSubjectDAO.findAll().size(), 73);

        // delete
        offeredSubjectDAO.delete(o37);
        Assert.assertEquals(offeredSubjectDAO.findAll().size(), 72);

        offeredSubjectDAO.delete(o37);
        Assert.assertEquals(offeredSubjectDAO.findAll().size(), 72);

        // findAll
        Assert.assertEquals(offeredSubjectDAO.findAll().size(), 72);


        // findByModulo
        Assert.assertEquals(offeredSubjectDAO.findByModulo(0, "2021-2022").size(), 18);
        Assert.assertEquals(offeredSubjectDAO.findByModulo(1, "2021-2022").size(), 18);

        // findByYearAndName
        Assert.assertEquals(offeredSubjectDAO.findByYearAndName("2021-2022", "Algebra 1").getTitle(), "Algebra 1");
        Assert.assertNull(offeredSubjectDAO.findByYearAndName("2021-2022", "Security Elements"));

        // findAllSubjectsByYearAndBySemester
        Assert.assertEquals(offeredSubjectDAO.findAllSubjectsByYearAndBySemester("2021-2022", 6).size(), 5);

        // findByYear
        Assert.assertEquals(offeredSubjectDAO.findByYear("2021-2022").size(), 36);

        // findByTitle
        Assert.assertEquals(offeredSubjectDAO.findByTitle("Algebra 1").getTitle(), "Algebra 1");
        Assert.assertNull(offeredSubjectDAO.findByTitle("Security Elements"));
    }

    @Test
    public void TestSecretary() {
        // save
        Secretary r1 = new Secretary(12345, "p12345", "0000", "Eusta8ios", "Xaralampidhs");
        secretaryDAO.save(r1);
        Assert.assertEquals(secretaryDAO.findAll().size(), 1);

        Secretary r2 = new Secretary(56789, "p56789", "1111", "Basilhs", "Donis");
        secretaryDAO.save(r2);
        Assert.assertEquals(secretaryDAO.findAll().size(), 2);

        // delete
        secretaryDAO.delete(r2);
        Assert.assertEquals(secretaryDAO.findAll().size(), 1);

        secretaryDAO.delete(r2);
        Assert.assertEquals(secretaryDAO.findAll().size(), 1);

        // findSecretary
        Assert.assertEquals(secretaryDAO.findSecretary("p12345", "0000").getId(), 12345);
        Assert.assertNull(secretaryDAO.findSecretary("nuc", "cie923"));

        // findAll
        Assert.assertEquals(1, secretaryDAO.findAll().size());
    }

    @Test
    public void TestSubject() {
        // save
        subjectDAO.save(new Subject("Euagellia Vagena", 8, "Introduction on Elements of law and information", "Elements of law and information"));
        Assert.assertEquals(subjectDAO.findAll().size(), 36);

        subjectDAO.save(new Subject("Euagellia Vagena", 8, "Introduction on elements of security", "Security Elements"));
        Assert.assertEquals(subjectDAO.findAll().size(), 37);

        // delete
        subjectDAO.delete(new Subject("Euagellia Vagena", 8, "Introduction on elements of security", "Security Elements"));
        Assert.assertEquals(subjectDAO.findAll().size(), 36);

        subjectDAO.delete(new Subject("Euagellia Vagena", 8, "Introduction on elements of security", "Security Elements"));
        Assert.assertEquals(subjectDAO.findAll().size(), 36);

        // findAll
        Assert.assertEquals(subjectDAO.findAll().size(), 36);

        // findSubject
        Assert.assertNull(subjectDAO.findSubject("Security Elements"));

        Assert.assertEquals(subjectDAO.findSubject("Algebra 1").getProfessor(), "Stauros Toumpis");

        // getNewId
        Assert.assertTrue(subjectDAO.getNewId() > 36); // changes  also in the other tests, so we test if it greater than the original 36

        // exists
        Assert.assertTrue(subjectDAO.exists("Algebra 1"));
        Assert.assertFalse(subjectDAO.exists("Security Elements"));
    }

    @Test
    public void TestSubmission() throws Exception {
        Subject su36 = new Subject("Euagellia Vagena", 8, "Introduction on Elements of law and information", "Elements of law and information");
        Student s1 = new Student(3200125, "p3200125", "Irma", "Lydia-Christina", "Wallace", 6);
        OfferedSubject o36 = new OfferedSubject(8, su36, academicYearDAO.find("2021-2022"));

        Submission sub = new Submission();
        sub.setStudent(s1);
        sub.setSemester(6);
        sub.setAcademicYear(academicYearDAO.find("2021-2022"));
        sub.addChosenSub(o36);

        submissionDAO.save(sub);

        Assert.assertEquals(submissionDAO.findAll().size(), 1);
        submissionDAO.save(sub);
        Assert.assertEquals(submissionDAO.findAll().size(), 1);
        submissionDAO.delete(sub);
        Assert.assertEquals(submissionDAO.findAll().size(), 0);
        submissionDAO.delete(sub);
        Assert.assertEquals(submissionDAO.findAll().size(), 0);
    }
}
