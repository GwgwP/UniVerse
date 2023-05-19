package gr.aueb.softeng.team02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.team02.model.Subject;

public class SubjectTest {
    private Subject subject;

    @Before
    public void setUp() {
        subject = new Subject(3319, "Kotidis Ioannis", 5, "introduction to Databases", "SDAD");
    }

    @Test
    public void check_emptiness_of_fields() {
        Subject subject2 = new Subject(0, null, 0, null, null);
        assertFalse(subject2.checkFields());

        subject2 = new Subject(0, null, 0, null, "ABC");
        assertFalse(subject2.checkFields());
        subject2 = new Subject(0, null, 0, "test", null);
        assertFalse(subject2.checkFields());
        subject2 = new Subject(0, null, 1, null, null);
        assertFalse(subject2.checkFields());
        subject2 = new Subject(0, "test", 0, null, null);
        assertFalse(subject2.checkFields());
        subject2 = new Subject(1, null, 0, null, null);
        assertFalse(subject2.checkFields());

        subject2 = new Subject(0, null, 0, "test", "ABC");
        assertFalse(subject2.checkFields());
        subject2 = new Subject(0, null, 1, "test", "ABC");
        assertFalse(subject2.checkFields());
        subject2 = new Subject(1, null, 0, "test", "ABC");
        assertFalse(subject2.checkFields());
        subject2 = new Subject(0, "test", 0, "test", "ABC");
        assertFalse(subject2.checkFields());
        subject2 = new Subject(0, "test", 1, "test", "ABC");
        assertFalse(subject2.checkFields());
        subject2 = new Subject(1, null, 1, "test", "ABC");
        assertFalse(subject2.checkFields());

        /*And many other cases of failure, there are a lot of combinations to try*/
        assertTrue(this.subject.checkFields());
    }

    @Test
    public void check_equals() {
        Subject subject2 = new Subject(1234, "Giannis Parios", 10, "introduction to robotics", "Robotics");
        Subject subject3 = new Subject(3319, "Mohamed Ali", 5, "introduction to aa", "aaa");

        assertEquals(subject3, this.subject);
        assertNotEquals(subject2, this.subject);
        subject3 = this.subject;
        assertEquals(subject3, this.subject);

        assertNotEquals(this.subject, null);

        Object other = new Object();
        assertNotEquals(subject, other);
        subject2.setId(3319);

        assertEquals(this.subject, subject2);
    }

    @Test
    public void check_hashCode() {
        Subject subject2 = new Subject(1234, "Giannis Parios", 10, "introduction to robotics", "Robotics");
        assertEquals(1234, subject2.hashCode());
        assertEquals(3319, this.subject.hashCode());
        assertNotEquals(2219, this.subject.hashCode());
        assertNotEquals(this.subject.hashCode(), subject2.hashCode());
        subject2.setId(3319);
        assertEquals(this.subject.hashCode(), subject2.hashCode());
    }

    @Test
    public void check_getters_setters() throws Exception {
        Subject subject2 = new Subject(1234, "Giannis Parios", 10, "introduction to robotics", "Robotics");
        Subject subject3 = new Subject(2543, "Mohamed Ali", 5, "introduction to aa", "aaa");

        assertTrue(subject2.checkFields());
        //adding subject2,3 as prerequisites to subject.
        this.subject.addPrerequisities(subject2);
        this.subject.addPrerequisities(subject3);

        //checking if they are included in subject
        assertEquals(this.subject.getPrerequisities().size(), 2);

        //checking id
        assertEquals(1234, subject2.getId());
        assertEquals(3319, this.subject.getId());
        assertEquals(2543, subject3.getId());

        //changing id at subject3
        subject3.setId(1212);
        assertEquals(1212, subject3.getId());

        //checking professor
        assertEquals("Giannis Parios", subject2.getProfessor());
        //changing professor and checking again
        subject2.setProfessor("maria callas");
        assertEquals("maria callas", subject2.getProfessor());

        //checking ects
        assertEquals(10, subject2.getECTS());
        //changing ects and checking again
        subject2.setECTS(8);
        assertEquals(8, subject2.getECTS());


        //checking description
        assertEquals("introduction to robotics", subject2.getDesc());
        //changing desc and checking again
        subject2.setDesc("akl");
        assertEquals("akl", subject2.getDesc());


        //checking title
        assertEquals("Robotics", subject2.getTitle());
        subject2.setTitle("ABG");
        assertEquals("ABG", subject2.getTitle());

    }

    @Test
    public void checkAddPrerequisities() throws Exception {
        Subject subject3 = new Subject(2543, "Mohamed Ali", 5, "introduction to aa", "aaa");
        this.subject.addPrerequisities(subject3);
        Subject subject2 = new Subject(2543, "Giannis Parios", 10, "introduction to robotics", "Robotics");

        Assert.assertThrows(Exception.class, () -> {
            this.subject.addPrerequisities(subject2);
        });
    }
}
