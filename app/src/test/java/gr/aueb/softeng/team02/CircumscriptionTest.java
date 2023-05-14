package gr.aueb.softeng.team02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

public class CircumscriptionTest {
    Circumscription c;
    Date start;
    Date end;
    @Before
    public void setUp() {
        this.start = new Date(2023, 2, 16);
        this.end = new Date(2023, 3, 25);
        this.c = new Circumscription(6, 60, start, end);
    }

    @Test
    public void checkGetters() {
        this.c.getEcts();
        this.c.getSemester();
        this.c.getEnd();
        this.c.getStart();
    }

    @Test
    public void checkSetters() {
        this.c.setSemester(1);
        this.c.setEcts(40);
        this.c.setEnd(new Date(2024, 9, 18));
        this.c.setStart(new Date(2025, 1, 23));

        Assert.assertNotSame(this.c.getStart(), start);
        Assert.assertNotSame(this.c.getEnd(), end);
        assertEquals(this.c.getSemester(), 1);
        assertEquals(this.c.getEcts(), 40);
    }
    @Test
    public void TestCheckValidity() {
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
