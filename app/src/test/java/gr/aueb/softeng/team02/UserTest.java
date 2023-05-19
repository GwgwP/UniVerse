package gr.aueb.softeng.team02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;

public class UserTest {
    private Student us;
    private Student rs;

    @Before
    public void setUp() {
        this.us = new Student(1, "Lydiacwall", "kk", "Lydia", "Wallace", 7);
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
        Assert.assertNotNull(sec);
    }
}
