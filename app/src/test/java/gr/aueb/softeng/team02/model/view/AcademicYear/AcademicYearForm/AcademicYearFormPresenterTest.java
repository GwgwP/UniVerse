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

    /**
     * Testing the page navigation
     */
    @Test
    public void TestPageIntent()
    {
        Assert.assertEquals(0, view.getIntent_to_reg());
        presenter.onSeeAcademicYear();
        Assert.assertEquals(1, view.getIntent_to_reg());
    }

    /**
     * Test for override
     * valid fields given from the user.
     */
    @Test
    public void TestVariousCombinationsOfFields() throws AcademicYearException {
        //everything valid but already existing form
        //checking override
        view.setPosition_year(0);
        Assert.assertEquals("2021-2022", view.getSelectedYear()); //this academic year already exists and has circumscription

        view.setPosition_sem(2);
        Assert.assertEquals("3", view.getSelectedSemester());

        view.setEcts("49");
        Assert.assertEquals("49", view.getECTS());

        view.setStart_date("2021-02-01");
        view.setEnd_date("2021-03-01");
        Assert.assertEquals("2021-02-01", view.getStart_date());
        Assert.assertEquals("2021-03-01", view.getEnd_date());


        presenter.checkValid();
        Assert.assertEquals(0, view.getFx());
        Assert.assertEquals(0, view.getSx());
        Assert.assertEquals(0, view.getTx());

        //the circumscription is valid, so we want the submit button to be visible
        Assert.assertEquals(1, view.getSubmit_visible());
        presenter.createAcademicYearCircumscription();
        //the check for the existing circumscription takes place when submit is clicked,
        //so we should get an alert message
        Assert.assertEquals(1, view.getMessage_alert());
        Assert.assertEquals("Warning", view.getTitle());
        Assert.assertEquals("There is already a circumscription for the same year and semester.\n Do you want to override it?", view.getMessage());


        //we know that the already existing circumscription has 30 ects as limit
        Assert.assertEquals(30, ac_years.findCircumscriptionBySemesterAndYear(3, "2021-2022").getEcts());
        //yes is clicked for override
        presenter.overrideCirc();
        //checking if the override has taken place
        Assert.assertEquals(1, view.getMessage_override());
        Assert.assertEquals(49, ac_years.findCircumscriptionBySemesterAndYear(3, "2021-2022").getEcts());
    }

    /**
     * First we create a new Academic Year.
     * Every field is valid
     */
    @Test
    public void Test_valid_creation()
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
        // submit is clicked
        presenter.createAcademicYearCircumscription();
        Assert.assertEquals(1, view.getMessage_save());

        Assert.assertEquals(0, view.getFx());
        Assert.assertEquals(0, view.getSx());
        Assert.assertEquals(0, view.getTx());
        //checking if the circumscription has been saved
        try {
            Assert.assertEquals(56, ac_years.findCircumscriptionBySemesterAndYear(3, "2024-2025").getEcts());
            Assert.assertEquals(l1, ac_years.find("2024-2025").getGradeDateEven());
            Assert.assertEquals(l2, ac_years.find("2024-2025").getGradeDateOdd());
        } catch (AcademicYearException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Testing various valid
     * and invalid user inputs
     */
    @Test
    public void Test_valid_invalid_combos()
    {
        //valid year
        view.setPosition_year(0);
        Assert.assertEquals("2021-2022", view.getSelectedYear());

        //valid semester
        view.setPosition_sem(2);
        Assert.assertEquals("3", view.getSelectedSemester());

        //valid ects
        view.setEcts("50");
        Assert.assertEquals("50", view.getECTS());

        //not valid dates
        view.setStart_date("");
        Assert.assertEquals(0, view.getStart_date().length());
        view.setEnd_date("202103ee2qwhua01");
        Assert.assertEquals("", view.getStart_date());
        Assert.assertEquals("202103ee2qwhua01", view.getEnd_date());


        presenter.checkValid();
        Assert.assertEquals(0, view.getFx());
        Assert.assertEquals(1, view.getSx());
        Assert.assertEquals(1, view.getTx());

        //not valid ects
        view.setStart_date("2024-02-01");
        view.setEnd_date("2024-03-01");
        view.setEcts("gd");
        Assert.assertEquals("gd", view.getECTS());
        presenter.checkValid();
        Assert.assertEquals(0, view.getSubmit_visible());
        Assert.assertEquals(1, view.getFx());
        Assert.assertEquals(1, view.getSx());
        Assert.assertEquals(1, view.getTx());

    }

    /**
     * Testing various valid
     *  and invalid user inputs
     */
    @Test
    public void test_valid_invalid_combos_2()
    {
        //all valid except ects
        view.setPosition_year(0);
        Assert.assertEquals("2021-2022", view.getSelectedYear());

        view.setPosition_sem(2);
        Assert.assertEquals("3", view.getSelectedSemester());
        view.setStart_date("2024-02-01");
        view.setEnd_date("2024-03-01");
        view.setEcts("2");
        Assert.assertEquals("2", view.getECTS());
        presenter.checkValid();
        Assert.assertEquals(0, view.getSubmit_visible());
        Assert.assertEquals(1, view.getFx());
        Assert.assertEquals(0, view.getSx());
        Assert.assertEquals(0, view.getTx());
        Assert.assertEquals(1, view.getMessage_not_valid());



        view.setEcts("");
        Assert.assertEquals(0, view.getECTS().length());

        presenter.checkValid();
        Assert.assertEquals(0, view.getSubmit_visible());
        Assert.assertEquals(2, view.getFx());
        Assert.assertEquals(0, view.getSx());
        Assert.assertEquals(0, view.getTx());
        Assert.assertEquals(1, view.getMessage_not_valid());
    }

    @Test
    public void tes6()
    {
        view.setPosition_year(0);
        Assert.assertEquals("2021-2022", view.getSelectedYear());

        view.setPosition_sem(2);
        Assert.assertEquals("3", view.getSelectedSemester());
        view.setStart_date("2024-02-01");
        view.setEnd_date("2024-03-01");
        view.setEcts("");
        Assert.assertEquals(0, view.getECTS().length());
        presenter.checkValid();

        Assert.assertEquals(0, view.getSubmit_visible());
        Assert.assertEquals(1, view.getFx());
        Assert.assertEquals(0, view.getSx());
        Assert.assertEquals(0, view.getTx());
        Assert.assertEquals(0, view.getMessage_not_valid());
    }

}
