package gr.aueb.softeng.team02.model.view.AcademicYear.AcademicYearForm;

import androidx.annotation.OpenForTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.view.AcademicYear.Registration.AcademicYearRegViewStub;
import gr.aueb.softeng.team02.model.view.Logo.LogoPresenterTest;
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
        Assert.assertEquals(0, view.getFx());
        Assert.assertEquals(0, view.getSx());
        Assert.assertEquals(0, view.getTx());

        Assert.assertEquals(1, view.getSubmit_visible());
        presenter.createAcademicYearCircumscription();
        Assert.assertEquals(1, view.getMessage_alert());

        Assert.assertEquals("Warning", view.getTitle());
        Assert.assertEquals("There is already a circumscription for the same year and semester.\n Do you want to override it?", view.getMessage());


        //yes is clicked for override
        presenter.overrideCirc();
        Assert.assertEquals(1, view.getMessage_override());



    }
    @Test
    public void Test2()
    {
        //everything valid
        //We create a new academic year so there will not be any override.
        LocalDate l1 = LocalDate.of(2024, 2, 1);
        LocalDate l2 = LocalDate.of(2025, 3, 1 );
        AcademicYear ac = new AcademicYear("2024-2025", l1, l2);
        this.ac_years.save(ac);
        presenter.initLists();

        view.setPosition_year(1);
        Assert.assertEquals("2024-2025", view.getSelectedYear());

        view.setPosition_sem(2);
        Assert.assertEquals("3", view.getSelectedSemester());

        view.setEcts("56");
        Assert.assertEquals("56", view.getECTS());

        view.setStart_date("2024-02-01");
        view.setEnd_date("2024-03-01");
        Assert.assertEquals("2024-02-01", view.getStart_date());
        Assert.assertEquals("2024-03-01", view.getEnd_date());

        presenter.checkValid();
        Assert.assertEquals(1, view.getSubmit_visible());
        presenter.createAcademicYearCircumscription();
        Assert.assertEquals(1, view.getMessage_save());

        Assert.assertEquals(0, view.getFx());
        Assert.assertEquals(0, view.getSx());
        Assert.assertEquals(0, view.getTx());
    }
    @Test
    public void Test3()
    {

        view.setPosition_year(0);
        Assert.assertEquals("2021-2022", view.getSelectedYear());

        view.setPosition_sem(2);
        Assert.assertEquals("3", view.getSelectedSemester());

        view.setEcts("50");
        Assert.assertEquals("50", view.getECTS());

        //not valid dates
        view.setStart_date("2021001");
        view.setEnd_date("202103ee2qwhua01");
        Assert.assertEquals("2021-02-01", view.getStart_date());
        Assert.assertEquals("2021-03-01", view.getEnd_date());


        presenter.checkValid();
        Assert.assertEquals(0, view.getFx());
        Assert.assertEquals(1, view.getSx());
        Assert.assertEquals(1, view.getTx());


    }

}
