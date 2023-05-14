package gr.aueb.softeng.team02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.*;
import java.util.Date;

public class GradeTest {

    Grade grade;

    @Before
    public void setUp() {
        this.grade = new Grade();
        this.grade.setGrade(10);
    }

    @Test
    public void checkEquals() {
        Grade grade1 = new Grade();
        grade1.setGrade(10);

        assertEquals(this.grade, grade1);

        this.grade.setGrade(9);
        assertNotEquals(this.grade, grade1);

        assertEquals(this.grade, this.grade);

        assertNotEquals(this.grade, null);

        Object other = new Object();
        assertNotEquals(this.grade, other);
    }

    @Test
    public void checkGetters() {
        Assert.assertEquals(this.grade.getGrade(), 10);
    }

    @Test(expected = RuntimeException.class)
    public void checkSetters() throws RuntimeException {
        this.grade.setGrade(9);
        this.grade.setGrade(-1);
    }
}
