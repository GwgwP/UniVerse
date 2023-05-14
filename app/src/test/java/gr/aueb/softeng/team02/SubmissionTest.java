package gr.aueb.softeng.team02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubmissionTest {
    private Submission submission;
    private AcademicYear year;
    private Student student;

    @Before
    public void setUp() {
        this.student = new Student();
        this.year = new AcademicYear("2022-2023");
        this.submission = new Submission();
    }

    @Test
    public void checkSetters() throws Exception {
        OfferedSubject sub = null;
        Assert.assertThrows(Exception.class, () -> {
            this.submission.setSemester(9);
        });

        Assert.assertThrows(Exception.class, () -> {
            this.submission.setSemester(0);
        });

        this.submission.setSemester(8);

        this.submission.setAcademicYear(this.year);

        this.submission.setStudent(this.student);

        Assert.assertThrows(Exception.class, () -> {
            this.submission.setChosenSub(sub);
        });

        OfferedSubject test = new OfferedSubject(2);

        submission.setChosenSub(test);

        Assert.assertThrows(Exception.class, () -> {
            this.submission.setChosenSub(test);
        });
    }

    @Test
    public void checkGetters() throws Exception {
        this.submission = new Submission(this.year, 6, this.student);

        Assert.assertEquals(this.submission.getAcademicYear(), this.year);

        Assert.assertEquals(this.submission.getSemester(), 6);

        Assert.assertEquals(this.student, this.submission.getStudent());

        Assert.assertEquals(this.submission.getChosenSub().size(), 0);

        OfferedSubject test = new OfferedSubject(2);

        this.submission.setChosenSub(test);

        Assert.assertEquals(this.submission.getChosenSub().size(), 1);

        Assert.assertThrows(Exception.class, () -> {
            this.submission.setChosenSub(test);
        });

        Assert.assertEquals(this.submission.getChosenSub().size(), 1);
    }

    @Test
    public void checkCalculateEcts() throws Exception {
        //TODO
    }
}
