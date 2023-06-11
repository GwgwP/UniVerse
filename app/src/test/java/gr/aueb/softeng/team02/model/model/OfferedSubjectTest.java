package gr.aueb.softeng.team02.model.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Grade;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.model.Subject;

public class OfferedSubjectTest {
    private OfferedSubject subject;
    private AcademicYear year;
    private Grade grade;
    private Subject sub;

    @Before
    public void setUp() {
        this.grade = new Grade();
        this.subject = new OfferedSubject(8);
        LocalDate dateOdd2024 = LocalDate.of(2024, 2, 28);
        LocalDate dateEven2024 = LocalDate.of(2024, 6, 1);
        this.year = new AcademicYear("2023-2024", dateEven2024, dateOdd2024);
        this.grade = new Grade();
        this.grade.setGrade(7);
        this.sub = new Subject("Katerinis", 8, "An introduction to linear algebra", "Mathematics 2");
    }

    @Test
    public void checkSetters() throws Exception {
        this.subject.setSemester(7);
        Assert.assertEquals(7,this.subject.getSemester());

        this.subject.setSub(this.sub);
        Assert.assertEquals(new Subject("Katerinis", 8, "An introduction to linear algebra", "Mathematics 2") ,this.subject.getSubject());
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

        this.subject.setSub(this.sub);

        Assert.assertEquals(this.subject.getDesc(), this.sub.getDesc());

        Assert.assertEquals(this.subject.getProf(), this.sub.getProfessor());

        Assert.assertEquals(this.subject.getEcts(), this.sub.getECTS());

        Assert.assertEquals(this.subject.getTitle(), this.sub.getTitle());

        Assert.assertEquals(this.subject.getSubject(), this.sub);
        this.subject.setSemester(3);
        Assert.assertEquals(this.subject.getSemester(), 3);
        Assert.assertEquals("2023-2024", this.subject.getAcademicYearINString());
    }

    @Test
    public void checkEquals() throws Exception {
        LocalDate dateOdd2024 = LocalDate.of(2023, 2, 28);
        LocalDate dateEven2024 = LocalDate.of(2023, 6, 1);
        OfferedSubject test = null;
        this.subject.setSub(this.sub);
        Assertions.assertThrows(Exception.class, () -> {
            this.subject.setYear(null);
        });
        this.subject.setYear(this.year);
        Assert.assertNotEquals(this.subject, this.year);
        Assert.assertEquals(this.subject, this.subject);
        Assert.assertNotEquals(this.subject, test);
        Assert.assertNotEquals(this.subject, new OfferedSubject(8, this.sub, new AcademicYear("2022-2023", dateEven2024, dateOdd2024)));
        Assert.assertNotEquals(this.subject, new OfferedSubject(8, new Subject("Katerinis", 8, "An introduction to algebra", "Mathematics"), this.year));
        Assert.assertNotEquals(this.subject, new OfferedSubject(8, new Subject("Katerinis", 8, "An introduction to algebra", "Mathematics"), new AcademicYear("2022-2023", dateEven2024, dateOdd2024)));
        Assert.assertEquals(this.subject, new OfferedSubject(2, this.sub, this.year));
    }
}
