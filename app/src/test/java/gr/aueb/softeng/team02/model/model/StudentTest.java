package gr.aueb.softeng.team02.model.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.team02.model.Student;
import gr.aueb.softeng.team02.model.StudentException;

public class StudentTest {
    private Student student;


    @Before
    public void setUp() {
        this.student = new Student(3200155, "gepap", "12345", "Georgios", "Papadopoulos", 2);
    }

    @Test
    public void check_updates() {
        //A random student has passed 9 subjects and at that
        // specific time has 9 as avg
        this.student.setAvg(9);
        this.student.setNumPassed(9);
        this.student.setTotalEcts(45);

        //the student passes another subject
        this.student.updateAvg(10, 1);
        this.student.updateEcts(5);

        //checking their updates
        assertEquals(9.1, this.student.getAvg(), 0);
        assertEquals(10, this.student.getNumPassed());
        assertEquals(50, this.student.getTotalEcts());

        //now the student  passes 3 more subjects
        this.student.updateAvg(10 + 9 + 7.5, 3);
        this.student.updateEcts(15);

        //checking again their updates
        assertEquals(9.038461538461538, this.student.getAvg(), 0.00001);
        assertEquals(13, this.student.getNumPassed());
        assertEquals(65, this.student.getTotalEcts());

    }

    @Test
    public void checkDEFConstr() {
        Student stud = new Student();
        assertNull(stud.getName());
    }

    @Test
    public void check_semesters_and_averages_per_semester() throws Exception {
        //Create a new Student & check their semester
        Student newStudent = new Student(3200000, "gelap", "12345", "Georgios", "Lapadopoulos", 7);
        newStudent.setAvgPerSemester(7, 5);
        assertEquals(7, newStudent.getSemester());

        //Check old student
        assertEquals(2, this.student.getSemester());
        //updating the average
        this.student.setAvgPerSemester(2, 10);

        //update & check the semester of the old student
        this.student.setSemester(3);
        assertEquals(3, this.student.getSemester());
        this.student.setAvgPerSemester(3, 9.1);

        //update & check the semester of the new student
        newStudent.setSemester(8);
        assertEquals(8, newStudent.getSemester());
        newStudent.setAvgPerSemester(8, 5.5);

        //checking averages for the 2 semesters on the old student
        assertEquals(10, this.student.getAvgBySpecificSemester(2), 0);
        assertEquals(9.1, this.student.getAvgBySpecificSemester(3), 0);

        //checking averages for the 2 semesters on the new student
        assertEquals(5, newStudent.getAvgBySpecificSemester(7), 0);
        assertEquals(5.5, newStudent.getAvgBySpecificSemester(8), 0);


    }

    @Test()
    public void checkExceptions() throws StudentException {
        assertThrows(StudentException.class, () -> {
            this.student.getAvgBySpecificSemester(0);
        });
        assertThrows(StudentException.class, () -> {
            this.student.setAvgPerSemester(0, 9);
        });
        assertThrows(StudentException.class, () -> {
            this.student.setAvgPerSemester(9, 8);
        });
    }

}


