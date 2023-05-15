package gr.aueb.softeng.team02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

import java.util.Date;

public class OfferedSubjectTest {
    private OfferedSubject subject;
    private AcademicYear year;
    private Grade grade;
    private Subject sub;

    @Before
    public void setUp() {
        this.grade = new Grade();
        this.subject = new OfferedSubject(8);
        this.year = new AcademicYear("2023-2024");
        this.grade = new Grade();
        this.grade.setGrade(7);
        this.sub = new Subject(1, "Katerinis", 8, "An introduction to linear algebra", "Mathematics 2");
    }

    @Test
    public void checkSetters() throws Exception {
        Assert.assertThrows(Exception.class, () -> {
            this.subject.setSemester(0);
        });

        Assert.assertThrows(Exception.class, () -> {
            this.subject.setSemester(9);
        });

        this.subject.setSemester(7);

        this.grade.setGrade(7);

        this.subject.setGrade(this.grade);

        this.subject.setSub(this.sub);

        this.subject.setYear(this.year);

        AcademicYear yeartest = new AcademicYear();
        Assert.assertThrows(Exception.class, () -> {
            this.subject.setYear(yeartest);
        });
    }

    @Test
    public void checkGetters() throws Exception {
        this.grade.setGrade(6);

        this.subject.setYear(this.year);
        Assert.assertSame(this.subject.getYear(), this.year);

        this.subject.setGrade(this.grade);
        Assert.assertNotSame(this.subject.getGrade(), this.grade);
        Assert.assertEquals(this.subject.getGrade(), this.grade);

        this.subject.setSub(this.sub);

        Assert.assertEquals(this.subject.getDesc(), this.sub.getDesc());

        Assert.assertEquals(this.subject.getProf(), this.sub.getProfessor());

        Assert.assertEquals(this.subject.getEcts(), this.sub.getECTS());

        Assert.assertEquals(this.subject.getTitle(), this.sub.getTitle());

        this.subject.setSemester(3);
        Assert.assertEquals(this.subject.getSemester(), 3);

    }
}
