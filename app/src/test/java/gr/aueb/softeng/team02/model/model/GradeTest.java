package gr.aueb.softeng.team02.model.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.Grade;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.model.Student;
import gr.aueb.softeng.team02.model.Subject;

public class GradeTest {

    Grade grade;
    Student student;
    OfferedSubject sub;

    Grade testGrade;
    @Before
    public void setUp() {
        this.grade = new Grade();
        this.grade.setGrade(10);
        this.student = new Student(3200199, "Panattack", "Aueb20022", "Panagiotis", "Triantafillidis", 6);
        this.sub = new OfferedSubject(6);
        Subject subject = new Subject( "Kotidis Ioannis", 5, "introduction to Databases", "SDAD");
        this.sub.setSub(subject);
        this.grade.setStudent(this.student);
        this.grade.setSubject(this.sub);
        Student student1 = new Student(3200199, "Panattack", "Aueb20022", "Panagiotis", "Triantafillidis", 6);
        OfferedSubject sub1 = new OfferedSubject(6);
        Subject subject1 = new Subject( "Kotidis Ioannis", 5, "introduction to Databases", "SDAD");
        sub1.setSub(subject1);
        this.testGrade = new Grade(student1, sub1, 9);
    }

    @Test
    public void checkCopyConstructor() {
        Grade testGrade = new Grade(this.grade);
        Assert.assertEquals(this.grade, testGrade);
    }

    @Test
    public void checkEquals() {
        Grade grade1 = new Grade();
        grade1.setGrade(10);

        assertEquals(this.grade, testGrade);
        grade1.setSubject(this.sub);
        grade1.setStudent(new Student(3200125, "WallC", "Aueb20022", "Christina", "Wallace", 6));
        assertNotEquals(this.grade, grade1);

        assertEquals(this.grade, this.grade);

        assertNotEquals(this.grade, null);

        Object other = new Object();
        assertNotEquals(this.grade, other);
    }

    @Test
    public void checkGetters() throws Exception {
        Assert.assertEquals(10, this.grade.getGrade());
        LocalDate dateOdd2023 = LocalDate.of(2023, 2, 28);
        LocalDate dateEven2023 = LocalDate.of(2023, 6, 1);
        AcademicYear year = new AcademicYear("2022-2023", dateEven2023, dateOdd2023);
        this.sub.setYear(year);
        Assert.assertEquals(this.grade.getAcademicYear(), new AcademicYear("2022-2023", dateEven2023, dateOdd2023));
        Assert.assertEquals(3200199, this.grade.getStudentId());
        Assert.assertEquals("SDAD", this.grade.getSubjectTitle());
        Assert.assertEquals(this.sub, this.grade.getSubject());
        assertEquals(6, this.testGrade.getSemester());
        assertEquals("SDAD", this.testGrade.getTitle());
    }

    @Test(expected = RuntimeException.class)
    public void checkSetters() throws RuntimeException {
        this.grade.setStudent(this.student);
        this.grade.setSubject(this.sub);
        this.grade.setGrade(-1);
    }

    @Test
    public void checkHashCode() {
        int h1 = this.grade.hashCode();
        int h2 = this.testGrade.hashCode();
        Assert.assertEquals(h2, h1);
    }
}
