package gr.aueb.softeng.team02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class StudentTest {
    private Student student;


    @Before
    public void setUp() {

        this.student = new Student(3200155, "gepap", "12345", "Georgios", "Papadopoulos", 2);

    }

    @Test
    public void check_updates() {
        this.student.setAvg(9);
        this.student.setNumPassed(9);
        this.student.setTotalEcts(45);
        this.student.updateEcts(5);

        this.student.updateAvg(10, 1);
        //this.student.setNumPassed(this.student.getNumPassed()+1);


        assertEquals(9.1, this.student.getAvg(), 0);
        assertEquals(10, this.student.getNumPassed());
        assertEquals(50, this.student.getTotalEcts());
    }

    @Test
    public void check_semester() throws Exception {
        assertEquals(2, this.student.getSemester());
        this.student.setSemester(3);
        assertEquals(3, this.student.getSemester());

        this.student.setAvgPerSemester(2, 10);
        assertEquals(10, this.student.getAvgBySpecificSemester(2), 0);


        this.student.setAvgPerSemester(3, 9.1);
        assertEquals(10, this.student.getAvgBySpecificSemester(2), 0);
        assertEquals(9.1, this.student.getAvgBySpecificSemester(3), 0);


    }

    @Test()//expected = Exception.class)
    public void checkExceptions() throws Exception {
        assertThrows(Exception.class, () -> {
            this.student.getAvgBySpecificSemester(0);

        });
    }

}


