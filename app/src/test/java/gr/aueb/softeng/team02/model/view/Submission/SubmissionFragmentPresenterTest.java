package gr.aueb.softeng.team02.model.view.Submission;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.util.SystemDateStub;
import gr.aueb.softeng.team02.view.Submission.SubmissionFragmentPresenter;

public class SubmissionFragmentPresenterTest {
    Initializer dataHelper;
    SubmissionFragmentPresenter presenter;
    SubmissionFragmentViewStub view;

    /**
     * Initialize the presenter, the student id and the daos
     *
     * @throws AcademicYearException
     */
    @Before
    public void setUp() throws AcademicYearException {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new SubmissionFragmentViewStub();
        presenter = new SubmissionFragmentPresenter(dataHelper.getAcademicYearDAO(), dataHelper.getOfferedSubjectDAO(), dataHelper.getStudentDAO(), dataHelper.getGradeDAO(), dataHelper.getSubmissionDAO(), dataHelper.getSubjectDAO());
        presenter.setView(view);
        presenter.setStudentId(3200125);
    }

    /**
     * Steps of scenario:
     * 1. Make form
     * 2. Check the size of the offered subjects that the view
     * 3. Select the 'Theory of computability and complexity' (any subject that the user cannot select)
     * 4. Check if the error messages are correct
     * 5. Secondly check when the user doesn't select a subject, an error message will occur
     * 6. Then add two offered subjects that the user can select
     * 7. Click the submit button check the message and the size of the dao
     * 8. Make a new submission
     * 9. The same scenario as before but after submitting the form, check if it has overwritten the olf submission
     */
    @Test
    public void SimpleTest() {
        // Create a new submission - no submission before
        presenter.makeForm();
        Assert.assertEquals(view.getMap().size(), 13);
        presenter.checkPrerequisites("Theory of computability and complexity");

        Assert.assertEquals(view.getErrormsg(), "Cannot select this subject because you had not passed at least one prerequisite course");
        Assert.assertEquals(view.getErrorTitle(), "Error");
        Assert.assertFalse(view.getChecker());

        presenter.submitClicked();

        Assert.assertEquals(view.getErrorTitle(), "Error");
        Assert.assertEquals(view.getErrormsg(), "Select at least one subject");

        presenter.checkPrerequisites("SDAD");
        Assert.assertTrue(view.getChecker());
        view.addSelectedTitle("SDAD");

        presenter.checkPrerequisites("Elements of law and information");
        Assert.assertTrue(view.getChecker());
        view.addSelectedTitle("Elements of law and information");
        SystemDateStub.setStub(LocalDate.of(2023, 6, 15));
        presenter.submitClicked();
        Assert.assertEquals(view.getPassedMsg(), "Successfully stored");
        Assert.assertEquals(dataHelper.getSubmissionDAO().findAll().size(), 1);
        view.changeToHomeScreen();

        view.clearTitles();

        // Create a new submission and delete the old one
        presenter.makeForm();
        Assert.assertEquals(view.getMap().size(), 13);
        presenter.checkPrerequisites("Theory of computability and complexity");

        Assert.assertEquals(view.getErrormsg(), "Cannot select this subject because you had not passed at least one prerequisite course");
        Assert.assertEquals(view.getErrorTitle(), "Error");
        Assert.assertFalse(view.getChecker());

        presenter.submitClicked();

        Assert.assertEquals(view.getErrorTitle(), "Error");
        Assert.assertEquals(view.getErrormsg(), "Select at least one subject");

        presenter.checkPrerequisites("SDAD");
        Assert.assertTrue(view.getChecker());
        view.addSelectedTitle("SDAD");

        presenter.checkPrerequisites("Elements of law and information");
        Assert.assertTrue(view.getChecker());
        view.addSelectedTitle("Elements of law and information");
        SystemDateStub.setStub(LocalDate.of(2023, 6, 15));
        presenter.submitClicked();
        Assert.assertEquals(view.getPassedMsg(), "Successfully stored");
        Assert.assertEquals(dataHelper.getSubmissionDAO().findAll().size(), 1);
        view.changeToHomeScreen();
    }

    /**
     * Steps of scenario:
     * 1. Make form
     * 2. Check the size of the offered subjects that the view presents
     */
    @Test
    public void TestInDifferentSemester() {
        presenter.setStudentId(3210125);
        presenter.makeForm();
        Assert.assertEquals(view.getMap().size(), 13);
    }

    /**
     * Steps of scenario:
     * 1. Create an academic year with no circumscription and set it as current year
     * 2. Check if it produces error messages
     */
    @Test
    public void noCircumscription() {
        LocalDate dateOdd2030 = LocalDate.of(2030, 2, 28);
        LocalDate dateEven2030 = LocalDate.of(2030, 8, 1);
        AcademicYear y3 = new AcademicYear("2030-2031", dateEven2030, dateOdd2030);
        dataHelper.getAcademicYearDAO().save(y3);
        dataHelper.getAcademicYearDAO().setCurrentAcadYear(y3);

        presenter.makeForm();
        presenter.checkPrerequisites("SDAD");
        Assert.assertTrue(view.getChecker());
        view.addSelectedTitle("SDAD");

        presenter.submitClicked();
        Assert.assertEquals(view.getErrorTitle(), "Error");
        Assert.assertEquals(view.getErrormsg(), "No circumscription for this semester, please wait until a secretary define a new one");
    }

    /**
     * Steps of scenario:
     * 1. Make a form
     * 2. Add some subjects
     * 3. Based on the circumscription, this submission is false, exceeds the limit of ects
     */
    @Test
    public void testTooManySubjectsInSubmitClicked() {
        presenter.makeForm();
        Assert.assertEquals(view.getMap().size(), 13);

        presenter.checkPrerequisites("SDAD");
        Assert.assertTrue(view.getChecker());
        view.addSelectedTitle("SDAD");

        presenter.checkPrerequisites("Software Verification and Validation");
        Assert.assertTrue(view.getChecker());
        view.addSelectedTitle("Software Verification and Validation");

        presenter.checkPrerequisites("Elements of law and information");
        Assert.assertTrue(view.getChecker());
        view.addSelectedTitle("Elements of law and information");

        presenter.checkPrerequisites("Distributed Systems");
        Assert.assertTrue(view.getChecker());
        view.addSelectedTitle("Distributed Systems");

        presenter.submitClicked();
        Assert.assertEquals(view.getErrorTitle(), "Error");
        Assert.assertEquals(view.getErrormsg(), "Surpassed the limit of ECTS for this semester");
    }

    /**
     * Steps od scenario:
     * 1. Make a form
     * 2. Select some subjects
     * 3. Submit the form
     * 4. Check the error messages based on the limits of start and end dates
     */
    @Test
    public void testLimitOfStartAndEven() {
        presenter.makeForm();
        Assert.assertEquals(view.getMap().size(), 13);

        presenter.checkPrerequisites("SDAD");
        Assert.assertTrue(view.getChecker());
        view.addSelectedTitle("SDAD");

        presenter.checkPrerequisites("Software Verification and Validation");
        Assert.assertTrue(view.getChecker());
        view.addSelectedTitle("Software Verification and Validation");

        presenter.checkPrerequisites("Elements of law and information");
        Assert.assertTrue(view.getChecker());
        view.addSelectedTitle("Elements of law and information");

        SystemDateStub.setStub(LocalDate.of(2023, 5, 14));
        presenter.submitClicked();
        Assert.assertEquals(view.getErrorTitle(), "Error");
        Assert.assertEquals(view.getErrormsg(), "The process of submission registration has not started yet !");

        SystemDateStub.setStub(LocalDate.of(2023, 7, 16));
        presenter.submitClicked();
        Assert.assertEquals(view.getErrorTitle(), "Error");
        Assert.assertEquals(view.getErrormsg(), "The process of submission registration has already come to an end !");
    }
}
