package gr.aueb.softeng.team02.model.view.AcademicYear.Registration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.view.AcademicYear.Registration.AcademicYearRegPresenter;

public class RegistrationPresenterTest {

    private Initializer init;
    private AcademicYearRegViewStub view;
    private AcademicYearRegPresenter presenter;

    private AcademicYearDAO ac_years;

    @Before
    public void setUp() throws AcademicYearException {
        init = new MemoryInitializer();
        init.prepareData();
        view = new AcademicYearRegViewStub();
        this.ac_years = init.getAcademicYearDAO();
        this.presenter = new AcademicYearRegPresenter(view, ac_years);

    }

    @Test
    public void test_various_combinations_of_fields() {
        //all fields correctly written
        view.setAc_year("2024-2025");
        Assert.assertEquals("2024-2025", view.getAcademicYear());

        //LocalDate start = LocalDate.of(2024, 2, 1);
        view.setStart_date("2024-02-01");
        Assert.assertEquals("2024-02-01",view.getStart_date());
        Assert.assertNotEquals("", view.getStart_date());


        //LocalDate end = LocalDate.of(2025, 3, 1);
        view.setEnd_date("2025-03-01");
        Assert.assertEquals("2025-03-01", view.getEnd_date());
        Assert.assertNotEquals("", view.getEnd_date());

        presenter.valid();
        Assert.assertEquals(0, view.getFx());
        Assert.assertEquals(0, view.getSx());
        Assert.assertEquals(0, view.getTx());

        //not valid year
        view.setAc_year("");
        Assert.assertEquals("", view.getAcademicYear());

        //LocalDate start2 = LocalDate.of(2024, 2, 1);
        view.setStart_date("2024-02-01");
        Assert.assertEquals("2024-02-01",view.getStart_date().toString());
        Assert.assertNotEquals("", view.getStart_date().toString());

        //LocalDate end2 = LocalDate.of(2025, 3, 1);
        view.setEnd_date("2025-03-01");
        Assert.assertEquals("2025-03-01", view.getEnd_date().toString());
        Assert.assertNotEquals("", view.getEnd_date().toString());
        presenter.valid();

        //only year not written so we want the x of year to be invoked
        Assert.assertEquals(1, view.getFx());
        Assert.assertEquals(0, view.getSx());
        Assert.assertEquals(0, view.getTx());
        Assert.assertEquals(1, view.getMessage_save());

        //not valid start date
        view.setAc_year("2026-2027");
        //LocalDate start3 = LocalDate.of(2026, 3, 1);
        view.setStart_date("2026-03-01");
        Assert.assertEquals("2026-03-01",view.getStart_date().toString());
        Assert.assertNotEquals("", view.getStart_date().toString());

        //LocalDate end3 = LocalDate.of(2027, 5, 1);
        view.setEnd_date("2027-05-01");
        Assert.assertEquals("2027-05-01", view.getEnd_date().toString());
        Assert.assertNotEquals("", view.getEnd_date().toString());
        presenter.valid();

        //only year not written so we want the x of year to be invoked
        Assert.assertEquals(1, view.getFx()); //from previous validation
        Assert.assertEquals(1, view.getSx());
        Assert.assertEquals(0, view.getTx());

        //not valid end date
        view.setAc_year("2026-2027");
        //LocalDate start4 = LocalDate.of(2026, 2, 1);
        view.setStart_date("2026-02-01");
        Assert.assertEquals("2026-02-01",view.getStart_date());
        Assert.assertNotEquals("", view.getStart_date());

        //LocalDate end4 = LocalDate.of(2027, 4, 1);
        view.setEnd_date("2027-04-01");
        Assert.assertEquals("2027-04-01", view.getEnd_date());
        Assert.assertNotEquals("", view.getEnd_date());
        presenter.valid();


        //only year not written so we want the x of year to be invoked
        Assert.assertEquals(1, view.getFx()); //from previous validation
        Assert.assertEquals(1, view.getSx()); //from previous validation
        Assert.assertEquals(1, view.getTx());


        //not valid format of year
        view.setAc_year("2002091919");
        presenter.valid();
        Assert.assertEquals(1, view.getAlert_message());
        Assert.assertEquals("Not valid year", view.getTitle());
        Assert.assertEquals("The year you are trying to submit does not have the right format", view.getMessage());
        Assert.assertEquals(2, view.getFx()); //from previous validation
        Assert.assertEquals(1, view.getSx()); //from previous validation
        Assert.assertEquals(1, view.getTx());

        view.setAc_year("");
        presenter.valid();
        Assert.assertEquals(1, view.getAlert_message());
        Assert.assertEquals("Not valid year", view.getTitle());
        Assert.assertEquals("The year you are trying to submit does not have the right format", view.getMessage());
        Assert.assertEquals(3, view.getFx()); //from previous validation
        Assert.assertEquals(1, view.getSx()); //from previous validation
        Assert.assertEquals(1, view.getTx());

        //the year already exists
        //we have initialized the DAO with years 2021-2022 so we know that this
        //already exists

        //all fields correctly written
        view.setAc_year("2021-2022");
        Assert.assertEquals("2021-2022", view.getAcademicYear());

        view.setStart_date("2024-02-01");
        Assert.assertEquals("2024-02-01",view.getStart_date());
        Assert.assertNotEquals("", view.getStart_date());


        view.setEnd_date("2025-03-01");
        Assert.assertEquals("2025-03-01", view.getEnd_date());
        Assert.assertNotEquals("", view.getEnd_date());

        presenter.valid();
        Assert.assertEquals(1, view.getMessage_not_save());

        //empty dates
        view.setStart_date("");
        view.setEnd_date("");
        Assert.assertEquals("", view.getStartDate());
        Assert.assertEquals("", view.getEnd_date());
        presenter.valid();

        Assert.assertEquals(3, view.getFx()); //from previous validation
        Assert.assertEquals(2, view.getSx()); //from previous validation
        Assert.assertEquals(2, view.getTx());



        view.setStart_date("e538238ue");
        view.setEnd_date("32590798");
        presenter.valid();
        Assert.assertEquals(3, view.getFx()); //from previous validation
        Assert.assertEquals(3, view.getSx()); //from previous validation
        Assert.assertEquals(3, view.getTx());

        //for not valid format of date.
        //the accepted format is YYYY-MM-DD
        //we cant pass dd-mm-yyyy because the local date accepts only yyyy-mm-dd




    }




}
