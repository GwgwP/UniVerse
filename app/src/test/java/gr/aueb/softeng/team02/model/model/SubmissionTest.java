package gr.aueb.softeng.team02.model.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.Circumscription;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.model.Student;
import gr.aueb.softeng.team02.model.Subject;
import gr.aueb.softeng.team02.model.Submission;

public class SubmissionTest {
    private Submission submission;
    private AcademicYear year;
    private Student student;
    Circumscription c;
    LocalDate start;
    LocalDate end;

    @Before
    public void setUp() {
        this.student = new Student();
        this.student.setId(3200199);
        LocalDate dateOdd2023 = LocalDate.of(2023, 2, 28);
        LocalDate dateEven2023 = LocalDate.of(2023, 6, 1);
        this.year = new AcademicYear("2022-2023", dateEven2023, dateOdd2023);
        this.submission = new Submission();
        this.start = LocalDate.of(2023, 2, 16);
        this.end = LocalDate.of(2023, 3, 25);
        this.c = new Circumscription(8, 31, start, end);
    }

    @Test
    public void checkSetters() throws Exception {
        OfferedSubject sub = null;

        this.submission.setSemester(8);
        this.year.addCircumscription(this.c);

        this.submission.setAcademicYear(this.year);
        this.submission.setStudent(this.student);

        Assert.assertThrows(Exception.class, () -> {
            this.submission.addChosenSub(sub);
        });

        Subject subject = new Subject("Kotidis Ioannis", 10, "introduction to Databases", "SDAD");
        OfferedSubject test = new OfferedSubject(6);
        test.setSub(subject);

        Subject subject1 = new Subject("Ioannis Maleuris", 10, "Epali8eush & Epikurwsh Logismikou", " E&El");
        OfferedSubject test1 = new OfferedSubject(6);
        test1.setSub(subject1);

        Subject subject2 = new Subject("Ion Androutsopoulos", 12, "Artificial Intelligence", " AI");
        OfferedSubject test2 = new OfferedSubject(5);
        test2.setSub(subject2);

        this.submission.addChosenSub(test);

        Assert.assertThrows(Exception.class, () -> {
            this.submission.addChosenSub(test);
        });

       this.submission.addChosenSub(test1);

        Assert.assertThrows(Exception.class, () -> {
            this.submission.addChosenSub(test2);
        });
    }

    @Test
    public void checkGetters() throws Exception {
        this.submission = new Submission(this.year, 8, this.student);

        Assert.assertEquals(this.submission.getAcademicYear(), this.year);

        Assert.assertEquals(this.submission.getSemester(), 8);

        Assert.assertEquals(this.student, this.submission.getStudent());

        Assert.assertEquals(this.submission.getChosenSub().size(), 0);

        OfferedSubject test = new OfferedSubject(2);
        Subject subject2 = new Subject("Giannis Parios", 10, "introduction to robotics", "Robotics");
        test.setSub(subject2);
        this.year.addCircumscription(this.c);
        this.submission.setAcademicYear(this.year);


        this.submission.addChosenSub(test);

        Assert.assertEquals(this.submission.getChosenSub().size(), 1);

        Assert.assertThrows(Exception.class, () -> {
            this.submission.addChosenSub(test);
        });

        Assert.assertNotEquals(this.submission.getChosenSub().size(), 2);
        Assert.assertEquals(3200199, this.submission.getStudentId());
    }

    @Test
    public void checkCalculateEcts() throws Exception {
        Assert.assertEquals(this.submission.calculateECTS(), 0);

        Subject subject2 = new Subject("Giannis Parios", 10, "introduction to robotics", "Robotics");
        Subject subject3 = new Subject("Mohamed Ali", 5, "introduction to aa", "aaa");

        OfferedSubject sub1 = new OfferedSubject(6);
        OfferedSubject sub2 = new OfferedSubject(6);

        sub1.setSub(subject2);
        sub2.setSub(subject3);
        this.year.addCircumscription(this.c);
        this.submission.setAcademicYear(this.year);
        this.submission.setSemester(8);
        this.submission.addChosenSub(sub1);
        this.submission.addChosenSub(sub2);

        Assert.assertEquals(this.submission.calculateECTS(), 15);
    }

    @Test
    public void checkEquals() {
        Assert.assertNotEquals(this.submission, null);
        Submission sub = this.submission;
        Assert.assertEquals(this.submission, sub);
        Object object = new Object();
        Assert.assertNotEquals(this.submission, object);

        this.submission = new Submission(this.year, 8, this.student);
        Submission sub1 = new Submission(this.year, 8, new Student(000, "cime", "09329", "iwdmci", "oc", 7));
        Submission sub2 = new Submission(new AcademicYear("2019-2020", LocalDate.of(2020, 7, 8), LocalDate.of(2020, 2, 27)), 8, this.student);
        Submission sub3 = new Submission(this.year, 7, this.student);
        Submission sub4 = new Submission(this.year, 8, this.student);

        Assert.assertNotEquals(this.submission, sub1);
        Assert.assertNotEquals(this.submission, sub2);
        Assert.assertNotEquals(this.submission, sub3);
        Assert.assertEquals(this.submission, sub4);
    }
}
