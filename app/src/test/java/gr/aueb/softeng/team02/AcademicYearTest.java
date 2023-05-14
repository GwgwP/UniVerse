package gr.aueb.softeng.team02;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

import java.util.Date;

public class AcademicYearTest {
    private AcademicYear year;
    Date start;
    Date end;
    @Before
    public void setUp() {
        this.year = new AcademicYear("2022-2023");
        this.start = new Date(2023, 2, 16);
        this.end = new Date(2023, 3, 25);
    }

    /*Check the equality of two AcademicYear objects*/
    @Test
    public void checkEquals_HashCode() throws AcademicYearException {
        AcademicYear year2 = new AcademicYear("2021-2022");
        assertNotEquals(this.year, year2);
        assertNotEquals(this.year.hashCode(), year2.hashCode());

        year2.setAc_year("2022-2023");
        assertEquals(this.year, year2);
        assertEquals(year.hashCode(), year2.hashCode());

        Object other = new Object();
        assertNotEquals(this.year, other);

        AcademicYear yearTest = this.year;
        assertEquals(this.year, yearTest);

        yearTest = null;
        assertNotEquals(this.year, yearTest);
    }

    /*Check AddCircumscription*/
    @Test(expected = AcademicYearException.class)
    public void checkGetCircumscriptionException() throws AcademicYearException {
        Circumscription c1 = new Circumscription(1, 90, start, end);
        this.year.addCircumscription(c1);
        this.year.getCircumscription(1);
        this.year.getCircumscription(2);
    }
    @Test(expected = AcademicYearException.class)
    public void checkAddCircumscription() throws AcademicYearException {
        Circumscription c = new Circumscription(1, 80, start, end);
        this.year.addCircumscription(c);
        Circumscription c1 = new Circumscription(1, 90, start, end);
        Circumscription finalC = c1;
        Assertions.assertThrows(AcademicYearException.class, () -> {
            this.year.addCircumscription(finalC);
        });
        Circumscription c2 = new Circumscription(9, 90, start, end);
        Assertions.assertThrows(AcademicYearException.class, () -> {
            this.year.addCircumscription(c2);
        });
        Circumscription c3 = null;
        this.year.addCircumscription(c3);
    }

    @Test(expected = AcademicYearException.class)
    public void checkAddCircumscriptionException() throws AcademicYearException {
        Circumscription c1 = new Circumscription(2, 90, start, end);
        this.year.addCircumscription(c1);
        this.year.addCircumscription(c1);
    }

    @Test(expected = AcademicYearException.class)
    public void checkSetYear() throws AcademicYearException {
        Assertions.assertThrows(AcademicYearException.class, () -> {
            this.year.setAc_year(null);
        });
        this.year.setAc_year("2023-2024");
        this.year.setAc_year("2020--2021");
    }

    @Test
    public void checkGetYear() {
        assertEquals(this.year.getAc_year(), "2022-2023");
    }
}
