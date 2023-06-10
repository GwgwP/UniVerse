package gr.aueb.softeng.team02.model.view.Student;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.view.Secretary.SecretaryViewStub;
import gr.aueb.softeng.team02.view.Secretary.HomeSecretaryPresenter;
import gr.aueb.softeng.team02.view.Student.HomeStudentPresenter;

public class HomeStudentPresenterTest {
    private HomeStudentPresenter presenter;
    private StudentHomeViewStub view;
    private Initializer init;

    @Before
    public void setUp() throws AcademicYearException {
        init = new MemoryInitializer();
        init.prepareData();
        view = new StudentHomeViewStub();
        presenter = new HomeStudentPresenter(view);
    }

    @Test
    public void testChangeFragment() {
        //We selected the home screen
        presenter.changeFragment(R.id.homeFragment);
        Assert.assertEquals(1, view.getK());

        //We selected the academic year screen
        presenter.changeFragment(R.id.submissionFragment);
        Assert.assertEquals(2, view.getK());

        //We selected the subject screen
        presenter.changeFragment(R.id.progressFragment);
        Assert.assertEquals(3, view.getK());

        //We selected the offered subject screen
        presenter.changeFragment(R.id.searchFragment);
        Assert.assertEquals(4, view.getK());
    }
}
