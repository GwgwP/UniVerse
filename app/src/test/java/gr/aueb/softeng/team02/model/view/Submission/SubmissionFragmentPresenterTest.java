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

    @Before
    public void setUp() throws AcademicYearException {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new SubmissionFragmentViewStub();
        presenter = new SubmissionFragmentPresenter(dataHelper.getAcademicYearDAO(), dataHelper.getOfferedSubjectDAO(), dataHelper.getStudentDAO(), dataHelper.getGradeDAO(), dataHelper.getSubmissionDAO(), dataHelper.getSubjectDAO());
        presenter.setView(view);
        presenter.setStudentId(3200125);
    }

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

    @Test
    public void TestInDifferentSemester() {
        presenter.setStudentId(3210125);
        presenter.makeForm();
        Assert.assertEquals(view.getMap().size(), 13);
    }

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
