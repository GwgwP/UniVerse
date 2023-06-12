package gr.aueb.softeng.team02.model.view.OfferedSubject.OfferedSubjectRegistration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.model.Subject;
import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectRegistration.OfferedSubjectRegistrationPresenter;

public class OfferedSubjectRegistrationPresenterTest {
    private OfferedSubjectRegistrationPresenter presenter;
    OfferedSubjectRegistrationViewStub view;
    Initializer dataHelper;

    /**
     * Initialize the daos, presenter and the view
     *
     * @throws AcademicYearException
     */
    @Before
    public void setUp() throws AcademicYearException {
        view = new OfferedSubjectRegistrationViewStub();
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        LocalDate dateOdd2022 = LocalDate.of(2022, 2, 28);
        LocalDate dateEven2022 = LocalDate.of(2022, 8, 1);
        AcademicYear y1 = new AcademicYear("2021-2022", dateEven2022, dateOdd2022);
        Subject su25 = new Subject("John Kotidis", 8, "Introduction on management and database systems", "SDAD");
        OfferedSubject o25 = new OfferedSubject(6, su25, y1);
        dataHelper.getOfferedSubjectDAO().delete(o25);
        presenter = new OfferedSubjectRegistrationPresenter(view, dataHelper.getOfferedSubjectDAO(), dataHelper.getSubjectDAO(), dataHelper.getAcademicYearDAO());
    }

    /**
     * Steps of scenario:
     * 1. Select a year and a semester (mark as selected)
     * 2. Select a subject
     * 3. Check the alert title and the alert message
     * 4. Press Yes (to move the semester)
     * 5. Check the moved semester
     * 6. Check the the messages
     */
    @Test
    public void checkIfPressedYes() {
        presenter.init("2021-2022", "6");
        Assert.assertEquals(view.getTitles().size(), 36);
        // Check a subject
        presenter.checkSubject("Algebra 1");
        Assert.assertEquals(view.getAlertMessage(), "This subject is already on another semester! Do you want to move it to the 6 semester ?");
        Assert.assertEquals(view.getAlertTitle(), "Warning");
        // Pressed Yes
        presenter.moveSubject();
        Assert.assertEquals(dataHelper.getOfferedSubjectDAO().findByYearAndName("2021-2022", "Algebra 1").getSemester(), 6);
        Assert.assertEquals(view.getMoveReminder(), "The subject " + "\'" + "Algebra 1" + "\'" + " has it's semester moved");
        Assert.assertTrue(view.getChecker());
    }

    /**
     * Steps of scenario:
     * 1. Select a year and a semester (mark as selected)
     * 2. Select a subject
     * 3. Check the alert title and the alert message
     * 4. Press Yes (to move the semester)
     * 5. Check the moved semester
     * 6. Check the the messages
     */
    @Test
    public void checkIfPressedNo() {
        presenter.init("2021-2022", "6");
        Assert.assertEquals(view.getTitles().size(), 36);
        presenter.checkSubject("SDAD");
        Assert.assertTrue(view.getChecker());
        // Check a subject
        presenter.checkSubject("Algebra 1");
        Assert.assertEquals(view.getAlertMessage(), "This subject is already on another semester! Do you want to move it to the 6 semester ?");
        Assert.assertEquals(view.getAlertTitle(), "Warning");
        // Pressed No
        presenter.remainSubject();
        Assert.assertEquals(view.getMoveReminder(), "No change");
        Assert.assertFalse(view.getChecker());
    }

    /**
     * Steps of scenario:
     * 1. Select a year and a semester (mark as selected)
     * 2. Register the submission
     * 3. Check the error messages
     * 4. Select a subject
     * 5. Submit the message with no complication (check it)
     */
    @Test
    public void noRegisteredOfferedSubjects() {
        presenter.init("2021-2022", "6");
        presenter.register();

        Assert.assertEquals(view.getErrorTitle(), "Error");
        Assert.assertEquals(view.getErrorMsg(), "Select at least one subject");

        presenter.checkSubject("SDAD");
        view.addTitles("SDAD");
        presenter.register();

        Assert.assertEquals(dataHelper.getOfferedSubjectDAO().findByYear("2021-2022").size(), 36);
        Assert.assertEquals(dataHelper.getOfferedSubjectDAO().findAllSubjectsByYearAndBySemester("2021-2022", 6).size(), 5);
        Assert.assertEquals(view.getMoveReminder(), "Your registration was a success !");
    }
}
