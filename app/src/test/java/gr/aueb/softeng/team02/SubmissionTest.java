package gr.aueb.softeng.team02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    Date start;
    Date end;

    @Before
    public void setUp() {
        this.student = new Student();
        this.year = new AcademicYear("2022-2023");
        this.submission = new Submission();
        this.start = new Date(2023, 2, 16);
        this.end = new Date(2023, 3, 25);
        this.c = new Circumscription(8, 31, start, end);
    }

    @Test
    public void checkSetters() throws Exception {
        OfferedSubject sub = null;
        Assert.assertThrows(Exception.class, () -> {
            this.submission.setSemester(9);
        });

        Assert.assertThrows(Exception.class, () -> {
            this.submission.setSemester(0);
        });

        this.submission.setSemester(8);
        this.year.addCircumscription(this.c);

        this.submission.setAcademicYear(this.year);
        this.submission.setStudent(this.student);

        Assert.assertThrows(Exception.class, () -> {
            this.submission.addChosenSub(sub);
        });

        Subject subject = new Subject(3319, "Kotidis Ioannis", 10, "introduction to Databases", "SDAD");
        OfferedSubject test = new OfferedSubject(6);
        test.setSub(subject);

        Subject subject1 = new Subject(3318, "Ioannis Maleuris", 10, "Epali8eush & Epikurwsh Logismikou", " E&El");
        OfferedSubject test1 = new OfferedSubject(6);
        test1.setSub(subject1);

        Subject subject2 = new Subject(3317, "Ion Androutsopoulos", 12, "Artificial Intelligence", " AI");
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
        Subject subject2 = new Subject(1234, "Giannis Parios", 10, "introduction to robotics", "Robotics");
        test.setSub(subject2);
        this.year.addCircumscription(this.c);
        this.submission.setAcademicYear(this.year);


        this.submission.addChosenSub(test);

        Assert.assertEquals(this.submission.getChosenSub().size(), 1);

        Assert.assertThrows(Exception.class, () -> {
            this.submission.addChosenSub(test);
        });

        Assert.assertNotEquals(this.submission.getChosenSub().size(), 2);
    }

    @Test
    public void checkCalculateEcts() throws Exception {
        Assert.assertEquals(this.submission.calculateECTS(), 0);

        Subject subject2 = new Subject(1234, "Giannis Parios", 10, "introduction to robotics", "Robotics");
        Subject subject3 = new Subject(2543, "Mohamed Ali", 5, "introduction to aa", "aaa");

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
}
