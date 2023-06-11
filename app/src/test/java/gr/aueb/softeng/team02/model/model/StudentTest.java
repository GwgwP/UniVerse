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
    public void checkDEFConstr() {
        Student stud = new Student();
        assertNull(stud.getName());
        stud.setSemester(6);
        assertEquals(6, stud.getSemester());
    }

    @Test
    public void checkEquality() {
        Student s1 = new Student(3200125, "p3200125", "Irma", "Lydia-Christina", "Wallace", 6);
        Student s2 = new Student(3200155, "p3200155", "Well", "Georgia", "Petsa", 6);

        assertNotEquals(s1, s2);
        Student s3 = new Student(3200125, "p3200125", "Irma", "Lydia-Christina", "Wallace", 6);
        assertEquals(s1, s3);

        Object other = new Object();
        assertNotEquals(s1, other);
        assertNotEquals(s1, null);
        assertEquals(s1, s1);
        assertEquals(s2.hashCode(), s2.hashCode());
        assertEquals(s1.hashCode(), s3.hashCode());
        assertNotEquals(s1.hashCode(), s2.hashCode());
    }
}


