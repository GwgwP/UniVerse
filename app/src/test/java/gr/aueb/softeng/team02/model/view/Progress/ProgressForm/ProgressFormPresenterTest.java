package gr.aueb.softeng.team02.model.view.Progress.ProgressForm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.view.Progress.ProgressForm.ProgressPresenter;

public class ProgressFormPresenterTest {
    private Initializer init;
    private ProgressPresenter presenter;
    private ProgressFormViewStub view;
    private GradeDAO grades;

    @Before
    public void setUp() throws AcademicYearException {
        init = new MemoryInitializer();
        init.prepareData();  // this line throws academic year exception but we know that it will not
        view = new ProgressFormViewStub();
        presenter = new ProgressPresenter();
        presenter.setView(view);
        presenter.setGradesDao(init.getGradeDAO());
        grades = init.getGradeDAO();

        view.setStudent_id(3200125);


    }

    /**
     * Testing intent to new page
     */
    @Test
    public void Testinitentodetailedgrades()
    {
        presenter.onSeeGrades();
        Assert.assertEquals(1, view.getOnseegrades());
    }

    /**
     * Test for validity of averages per semester,
     * total average, ects, number  of passed subjects
     */
    @Test
    public void Testing_vlidity_of_numbers_produced()
    {

        //checking validity of student id
        view.setStudent_id(3200125);
        Assert.assertEquals(3200125, view.getStudent_id());
        Assert.assertNotEquals(3200155, view.getStudent_id());
        Assert.assertNotEquals(3200199, view.getStudent_id());


        //checking correctness of average
        presenter.getAverage(view.getStudent_id());
        Assert.assertEquals(7.76, view.getAverage(), 0.01);
        Assert.assertEquals(1, view.getShown_avg());
        Assert.assertEquals(0, view.getOnseegrades());
        Assert.assertEquals(0, view.getTimes_shown_avgs());
        Assert.assertEquals(0, view.getShown_passed_subjs());


        //checking validity of averages per semester
        presenter.getAGperSem(view.getStudent_id());
        Assert.assertEquals(1, view.getShown_avg());
        Assert.assertEquals(0, view.getOnseegrades());
        Assert.assertEquals(1, view.getTimes_shown_avgs());
        Assert.assertEquals(0, view.getShown_passed_subjs());
        Assert.assertEquals(0, view.getEctsShown());
        Assert.assertEquals(8.2, view.getAv_grades().get(1), 0.0001);
        Assert.assertEquals(9.0, view.getAv_grades().get(2), 0.0001);
        Assert.assertEquals(5.0, view.getAv_grades().get(3), 0.0001); // checking if average grade is correct brecause one subject has grade 4 so it is not passed
        Assert.assertNull(view.getAv_grades().get(4));
        Assert.assertNull(view.getAv_grades().get(5));
        Assert.assertNull(view.getAv_grades().get(6));
        Assert.assertNull(view.getAv_grades().get(7));
        Assert.assertNull(view.getAv_grades().get(8));


        //checking ECTS
        presenter.getECTS(view.getStudent_id());
        Assert.assertEquals(1, view.getEctsShown());
        Assert.assertEquals(104, view.getEcts());

        Assert.assertEquals(1, view.getShown_avg());
        Assert.assertEquals(0, view.getOnseegrades());
        Assert.assertEquals(1, view.getTimes_shown_avgs());
        Assert.assertEquals(0, view.getShown_passed_subjs());
        Assert.assertEquals(1, view.getEctsShown());


        //checking num of passed subjects
        presenter.getNumOfSubs(view.getStudent_id());
        Assert.assertEquals(3200125, view.getStudent_id());
        Assert.assertEquals(1, view.getShown_passed_subjs());
        Assert.assertEquals(13, view.getNumber_of_passed_subjects());

        Assert.assertEquals(1, view.getShown_avg());
        Assert.assertEquals(0, view.getOnseegrades());
        Assert.assertEquals(1, view.getTimes_shown_avgs());
        Assert.assertEquals(1, view.getShown_passed_subjs());
        Assert.assertEquals(1, view.getEctsShown());

    }
}
