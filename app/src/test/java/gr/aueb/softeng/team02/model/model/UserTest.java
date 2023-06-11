package gr.aueb.softeng.team02.model.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;

public class UserTest {
    private Student us;
    private Student rs;
    private Secretary s1;
    private Secretary s2;

    @Before
    public void setUp() {
        this.us = new Student(1, "Lydiacwall", "kk", "Lydia", "Wallace", 7);
        this.s2 = new Secretary(23456, "p23456", "2312", "Spyros", "Spyrou");
        this.s1 = new Secretary(98765, "p98765", "5544", "Tryfon", "Trufylli");
        this.rs = new Student();
    }

    @Test
    public void checkGetterSetters() {
        this.rs.setUsername("Gwgwpet");
        this.rs.setPassword("pi");
        this.rs.setId(2);
        this.rs.setName("Gwgw");
        this.rs.setSurname("Petsa");

        assertNotEquals(this.rs.getPassword(), this.us.getPassword());
        assertNotEquals(this.rs.getUsername(), this.us.getUsername());
        assertNotEquals(this.rs.getName(), this.us.getName());
        assertNotEquals(this.rs.getSurname(), this.us.getSurname());
        assertNotEquals(this.rs.getId(), this.us.getId());

        // Check Secretary
        Secretary sec = new Secretary();
        sec.setId(23456);
        Assert.assertNotNull(sec);

        Assert.assertEquals(sec, s2);
        assertNotEquals(sec, s1);
        assertNotEquals(sec, new Object());
        assertNotEquals(sec, null);
        assertEquals(sec, sec);

        assertEquals(sec.hashCode(), s2.hashCode());
        assertNotEquals(sec.hashCode(), s1.hashCode());
    }
}
