package gr.aueb.softeng.team02.model.view.OfferedSubject.OfferedSubjectRegistration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectRegistration.OfferedSubjectRegistrationPresenter;

public class OfferedSubjectRegistrationPresenterTest {
    private OfferedSubjectRegistrationPresenter presenter;
    OfferedSubjectRegistrationViewStub view;
    Initializer dataHelper;
    @Before
    public void setUp() throws AcademicYearException {
        view = new OfferedSubjectRegistrationViewStub();
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        presenter = new OfferedSubjectRegistrationPresenter(view, dataHelper.getOfferedSubjectDAO(), dataHelper.getSubjectDAO(), dataHelper.getAcademicYearDAO());
    }

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

}
