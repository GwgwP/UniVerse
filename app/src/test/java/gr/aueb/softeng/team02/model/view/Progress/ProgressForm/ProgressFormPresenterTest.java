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
        init.prepareData();
        view = new ProgressFormViewStub();
        presenter = new ProgressPresenter();
        presenter.setView(view);
        presenter.setGradesDao(init.getGradeDAO());
        grades = init.getGradeDAO();

        view.setStudent_id(3200125);


    }
    @Test
    public void Testinitentodetailedgrades()
    {
        presenter.onSeeGrades();
        Assert.assertEquals(1, view.getOnseegrades());
    }
    @Test
    public void getters_and_setters_test()
    {
        view.setStudent_id(3200125);

        Assert.assertEquals(3200125, view.getStudent_id());
        Assert.assertNotEquals(3200155, view.getStudent_id());
        Assert.assertNotEquals(3200199, view.getStudent_id());


        presenter.getAverage(view.getStudent_id());
        Assert.assertEquals(1, view.getShown_avg());
        Assert.assertEquals(0, view.getOnseegrades());
        Assert.assertEquals(0, view.getTimes_shown_avgs());
        Assert.assertEquals(0, view.getNumber_of_passed_subjects());
        Assert.assertEquals(0, view.getShown_passed_subjs());

        presenter.getAGperSem(view.getStudent_id());
        Assert.assertEquals(1, view.getShown_avg());
        Assert.assertEquals(0, view.getOnseegrades());
        Assert.assertEquals(1, view.getTimes_shown_avgs());
        Assert.assertEquals(0, view.getNumber_of_passed_subjects());
        Assert.assertEquals(0, view.getShown_passed_subjs());
        Assert.assertEquals(0, view.getEctsShown());

        presenter.getECTS(view.getStudent_id());
        Assert.assertEquals(1, view.getEctsShown());

        presenter.getNumOfSubs(view.getStudent_id());
        Assert.assertEquals(3200125, view.getStudent_id());
        Assert.assertEquals(1, view.getShown_passed_subjs());

    }
}
