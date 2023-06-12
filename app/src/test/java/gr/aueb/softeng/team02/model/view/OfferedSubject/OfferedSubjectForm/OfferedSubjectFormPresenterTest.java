package gr.aueb.softeng.team02.model.view.OfferedSubject.OfferedSubjectForm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectForm.OfferedSubjectPresenter;
import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectForm.OfferedSubjectView;

public class OfferedSubjectFormPresenterTest {

    Initializer dataHelper;
    OfferedSubjectPresenter presenter;
    OfferedSubjectViewStub view;

    /**
     * Initialize the daos, the view and the presenter
     *
     * @throws AcademicYearException
     */
    @Before
    public void setUp() throws AcademicYearException {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new OfferedSubjectViewStub();
        presenter = new OfferedSubjectPresenter(view, dataHelper.getOfferedSubjectDAO(), dataHelper.getAcademicYearDAO());
    }

    /**
     * Three scenarios:
     * 1. Submit a form with the preselected offered subjects
     *  1. Choose a year and a semester
     *  2. Check for the notification message that pops up when it has already registered offered subject the year and the semester
     *  3. Press the negative button
     *  4. Check if there was a deletion, also the messages and the dao size
     *  5. Check if the year and the semester were transferred as selected year and selected semester
     *  7. Transition to the next layout (no checking, just call the function it is the work of the activity not for us)
     *  ------------------------------------------------------------------------------------------------------------------------------
     * 2. Submit a form with no preselected offered subjects
     *  1. Choose a year and a semester
     *  2. Check if the year and the semester were transferred as selected year and selected semester
     *  ------------------------------------------------------------------------------------------------------------------------------
     * 3. Submit a form with the preselected offered subjects
     *  1. Choose a year and a semester
     *  2. Check for the notification message that pops up when it has already registered offered subject the year and the semester
     *  3. Press the positive button
     *  4. Check if there was no deletion with the size of the offered subject dao
     *  5. Transition to the home layout (no checking, just call the function it is the work of the activity not for us)
     */
    @Test
    public void checkSelected() {
        // Write in the form
        view.setYear("2021-2022");
        view.setSemester("8");
        presenter.initLists();
        Assert.assertEquals(view.getYearList().size(), 2);
        Assert.assertEquals(view.getSemesterList().size(), 8);
        presenter.checkSelected();
        Assert.assertEquals(view.getErrorTitle(), "Notification");
        Assert.assertEquals(view.getErrorMessage(), "You have already registered offered subjects for this year.Do you want to keep them ?");

        // pressed negative button
        presenter.onRegistration();
        Assert.assertEquals(view.getPopmsg(), "Deletion completed");
        Assert.assertEquals(view.getSelectedSemester(), "8");
        Assert.assertEquals(view.getSelectedYear(), "2021-2022");
        Assert.assertEquals(dataHelper.getOfferedSubjectDAO().findAllSubjectsByYearAndBySemester(view.getSelectedYear(), Integer.parseInt(view.getSelectedSemester())).size(), 0);

        // Save a new academic year in dao and check if there is not a registration form before
        dataHelper.getAcademicYearDAO().save(new AcademicYear("2024-2025", LocalDate.of(2025, 7, 1), LocalDate.of(2025, 2, 28)));
        view.setYear("2024-2025");
        view.setSemester("8");
        presenter.checkSelected();
        Assert.assertEquals(view.getYear(), "2024-2025");
        Assert.assertEquals(view.getSemester(), "8");
        Assert.assertEquals(view.getSelectedSemester(), "8");
        Assert.assertEquals(view.getSelectedYear(), "2024-2025");

        // Write a new form
        view.setYear("2022-2023");
        view.setSemester("8");
        presenter.initLists();
        Assert.assertEquals(view.getYearList().size(), 3);
        Assert.assertEquals(view.getSemesterList().size(), 8);
        presenter.checkSelected();
        Assert.assertEquals(view.getErrorTitle(), "Notification");
        Assert.assertEquals(view.getErrorMessage(), "You have already registered offered subjects for this year.Do you want to keep them ?");

        // pressed positive button
        Assert.assertEquals(5, dataHelper.getOfferedSubjectDAO().findAllSubjectsByYearAndBySemester(view.getYear(), Integer.parseInt(view.getSemester())).size());
        presenter.changeLayout();
    }

}
