package gr.aueb.softeng.team02;

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
        this.subject = new OfferedSubject(8);
        this.year = new AcademicYear("2023-2024");
        this.grade = new Grade();
        this.grade.setGrade(7);
        this.sub = new Subject(1, "Katerinis", 8, "An introduction to linear algebra", "Mathematics 2");
    }

}
