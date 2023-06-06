package gr.aueb.softeng.team02.model.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import gr.aueb.softeng.team02.model.Circumscription;

public class CircumscriptionTest {
    Circumscription c;
    LocalDate start;
    LocalDate end;
    @Before
    public void setUp() {
        this.start = LocalDate.of(2023, 2, 16);
        this.end = LocalDate.of(2023, 3, 25);
        this.c = new Circumscription(6, 60, start, end);
    }

    @Test
    public void checkGetters() {
        Assert.assertEquals(this.c.getEcts(), 60);
        this.c.getSemester();
        Assert.assertEquals(this.c.getSemester(), 6);
        this.c.getEnd();
        Assert.assertEquals(this.c.getStart(), start);
        this.c.getStart();
        Assert.assertEquals(this.c.getEnd(), end);
    }

    @Test
    public void checkSetters() throws Exception {
        this.c.setSemester(1);
        this.c.setEcts(40);
        this.c.setEnd(LocalDate.of(2024, 9, 18));
        this.c.setStart(LocalDate.of(2025, 1, 23));

        Assert.assertNotSame(this.c.getStart(), start);
        Assert.assertNotSame(this.c.getEnd(), end);
        assertEquals(this.c.getSemester(), 1);
        assertEquals(this.c.getEcts(), 40);
    }
    @Test
    public void TestCheckValidity() throws Exception {
        assertTrue(this.c.checkValidity());

        this.c.setSemester(0);
        assertFalse(this.c.checkValidity());

        this.c.setSemester(9);
        assertFalse(this.c.checkValidity());

        this.c.setSemester(6);
        this.c.setEcts(29);
        assertFalse(this.c.checkValidity());

        this.c.setSemester(6);
        this.c.setEcts(131);
        assertFalse(this.c.checkValidity());

        this.c.setSemester(0);
        this.c.setEcts(131);
        assertFalse(this.c.checkValidity());

        this.c.setSemester(0);
        this.c.setEcts(29);
        assertFalse(this.c.checkValidity());

        this.c.setSemester(9);
        this.c.setEcts(29);
        assertFalse(this.c.checkValidity());

        this.c.setSemester(9);
        this.c.setEcts(131);
        assertFalse(this.c.checkValidity());
    }
}
