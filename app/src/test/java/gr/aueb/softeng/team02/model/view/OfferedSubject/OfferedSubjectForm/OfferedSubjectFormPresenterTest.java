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

    @Before
    public void setUp() throws AcademicYearException {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new OfferedSubjectViewStub();
    }

    @Test
    public void checkSelected() {
        presenter = new OfferedSubjectPresenter(view, dataHelper.getSubjectDAO(), dataHelper.getOfferedSubjectDAO(), dataHelper.getAcademicYearDAO());

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

        dataHelper.getAcademicYearDAO().save(new AcademicYear("2024-2025", LocalDate.of(2025, 7, 1), LocalDate.of(2025, 2, 28)));
        view.setYear("2024-2025");
        view.setSemester("8");
        presenter.checkSelected();
        Assert.assertEquals(view.getYear(), "2024-2025");
        Assert.assertEquals(view.getSemester(), "8");
        Assert.assertEquals(view.getSelectedSemester(), "8");
        Assert.assertEquals(view.getSelectedYear(), "2024-2025");

        presenter.changeLayout();
    }


}
