package gr.aueb.softeng.team02.model.view.HomeStudentFragment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.view.HomeStudentFragment.StudentHomePresenter;

public class HomeStudentFragmentPresenter {

    private Initializer init;
    private StudentHomePresenter presenter;
    private HomeStudentFragmentViewStub view;

    @Before
    public void setUp() throws AcademicYearException {

        init = new MemoryInitializer();
        init.prepareData();
        view = new HomeStudentFragmentViewStub();
        presenter = new StudentHomePresenter();
        presenter.setView(view);

    }

    /**
     * We test if the presenter calls the right method
     **/
    @Test
    public void testPress() {

        presenter.press();
        Assert.assertEquals(1, view.getK());

    }
}
