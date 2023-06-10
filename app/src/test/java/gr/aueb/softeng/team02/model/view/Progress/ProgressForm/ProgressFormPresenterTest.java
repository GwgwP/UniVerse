package gr.aueb.softeng.team02.model.view.Progress.ProgressForm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.view.Progress.ProgressForm.ProgressPresenter;

public class ProgressFormPresenterTest {
    private Initializer init;
    private ProgressPresenter presenter;
    private ProgressFormViewStub view;

    @Before
    public void setUp(){
        init = new MemoryInitializer();
        view = new ProgressFormViewStub();
        presenter = new ProgressPresenter();
        presenter.setView(view);
        presenter.setGradesDao(init.getGradeDAO());
        view.setStudent_id(3200125);
    }
    @Test
    public void getters_and_setters_test()
    {
        Assert.assertEquals(3200125, view.getStudent_id());
        Assert.assertNotEquals(3200155, view.getStudent_id());
        Assert.assertNotEquals(3200199, view.getStudent_id());


        presenter.getAverage(view.getStudent_id());
        //view.setAverage(presenter.);
       // Assert.assertEquals(8.7, view.getAverage(), 0.00005);

    }
}
