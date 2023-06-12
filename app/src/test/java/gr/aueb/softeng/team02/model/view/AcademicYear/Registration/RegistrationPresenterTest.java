package gr.aueb.softeng.team02.model.view.AcademicYear.Registration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
        init.prepareData();  // this line throws academic year exception but we know that it will not
        view = new AcademicYearRegViewStub();
        this.ac_years = init.getAcademicYearDAO();
        this.presenter = new AcademicYearRegPresenter(view, ac_years);

    }

    /**
     * Testing registration of new academic year
     */
    @Test
    public void test_various_combinations_of_fields() {
        //all fields correctly written
        view.setAc_year("2024-2025");
        Assert.assertEquals("2024-2025", view.getAcademicYear());

        view.setStart_date("2024-02-01");
        Assert.assertEquals("2024-02-01",view.getStart_date());
        Assert.assertNotEquals("", view.getStart_date());


        view.setEnd_date("2025-03-01");
        Assert.assertEquals("2025-03-01", view.getEnd_date());
        Assert.assertNotEquals("", view.getEnd_date());

        presenter.valid();
        Assert.assertEquals(0, view.getFx());
        Assert.assertEquals(0, view.getSx());
        Assert.assertEquals(0, view.getTx());
        //checking if it is stored in the database
        Assert.assertEquals(ac_years.find("2024-2025").getAc_year(), "2024-2025");

        //-----------------other combination

        //not valid year
        view.setAc_year("");
        Assert.assertEquals("", view.getAcademicYear());

        view.setStart_date("2024-02-01");
        Assert.assertEquals("2024-02-01",view.getStart_date());
        Assert.assertNotEquals("", view.getStart_date());


        view.setEnd_date("2025-03-01");
        Assert.assertEquals("2025-03-01", view.getEnd_date());
        Assert.assertNotEquals("", view.getEnd_date());
        presenter.valid();

        //only year not written so we want the x of year to be invoked
        Assert.assertEquals(1, view.getFx());
        Assert.assertEquals(0, view.getSx());
        Assert.assertEquals(0, view.getTx());
        Assert.assertEquals(1, view.getMessage_save());
        Assert.assertNull(ac_years.find(""));

        //---------------other combination
        //not valid start date
        view.setAc_year("2026-2027");
        view.setStart_date("2026-03-01");
        Assert.assertEquals("2026-03-01",view.getStart_date());
        Assert.assertNotEquals("", view.getStart_date());

        view.setEnd_date("2027-05-01");
        Assert.assertEquals("2027-05-01", view.getEnd_date());
        Assert.assertNotEquals("", view.getEnd_date());
        presenter.valid();

        //only year not written so we want the x of year to be invoked
        Assert.assertEquals(1, view.getFx()); //from previous validation
        Assert.assertEquals(1, view.getSx());
        Assert.assertEquals(0, view.getTx());

        //-------------other combination
        //not valid end date
        view.setAc_year("2026-2027");
        view.setStart_date("2026-02-01");
        Assert.assertEquals("2026-02-01",view.getStart_date());
        Assert.assertNotEquals("", view.getStart_date());

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

        //---------other combo
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


        //other combo
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

    }

}
