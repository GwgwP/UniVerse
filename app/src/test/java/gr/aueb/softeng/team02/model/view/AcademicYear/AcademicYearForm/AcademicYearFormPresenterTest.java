package gr.aueb.softeng.team02.model.view.AcademicYear.AcademicYearForm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.view.AcademicYear.Registration.AcademicYearRegViewStub;
import gr.aueb.softeng.team02.view.AcademicYear.AcademicYearForm.AcademicYearFragmentPresenter;
import gr.aueb.softeng.team02.view.AcademicYear.AcademicYearForm.AcademicYearFragmentView;
import gr.aueb.softeng.team02.view.AcademicYear.Registration.AcademicYearRegPresenter;

public class AcademicYearFormPresenterTest {
    Initializer init;
    AcademicYearFragmentPresenter presenter;
    AcademicYearFormViewStub view;
    private AcademicYearDAO ac_years;

    @Before
    public void setUp() throws AcademicYearException {
        init = new MemoryInitializer();
        init.prepareData();
        view = new AcademicYearFormViewStub();
        this.ac_years = init.getAcademicYearDAO();
        this.presenter = new AcademicYearFragmentPresenter(ac_years);
        this.presenter.setView(view);
        presenter.initLists();
    }

    @Test
    public void TestPageIntent()
    {
        presenter.onSeeAcademicYear();
        Assert.assertEquals(1, view.getIntent_to_reg());
    }
    @Test
    public void TestVariousCombinationsOfFields()
    {
        //everything valid but already existing form
        //checking override
        view.setPosition_year(0);
        Assert.assertEquals("2021-2022", view.getSelectedYear());

        view.setPosition_sem(2);
        Assert.assertEquals("3", view.getSelectedSemester());

        view.setEcts("50");
        Assert.assertEquals("50", view.getECTS());

        view.setStart_date("2021-02-01");
        view.setEnd_date("2021-03-01");
        Assert.assertEquals("2021-02-01", view.getStart_date());
        Assert.assertEquals("2021-03-01", view.getEnd_date());


        presenter.checkValid();
        Assert.assertEquals(1, view.getMessage_override());




    }

}
