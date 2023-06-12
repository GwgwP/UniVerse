package gr.aueb.softeng.team02.model.view.Secretary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import java.util.Set;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Grade;
import gr.aueb.softeng.team02.model.util.SystemDateStub;
import gr.aueb.softeng.team02.view.Secretary.HomeSecretaryPresenter;


public class SecretaryPresenterTest {

    private HomeSecretaryPresenter presenter;
    private SecretaryViewStub view;
    private Initializer init;

    @Before
    public void setUp() throws AcademicYearException {
        init = new MemoryInitializer();
        init.prepareData();
        view = new SecretaryViewStub();
        presenter = new HomeSecretaryPresenter(view, init.getAcademicYearDAO());

    }

    /**
     * We test to see if the presenter changes to the correct fragment
     **/

    @Test
    public void testChangeFragment() {

        //We selected the home screen
        presenter.changeFragment(R.id.secretaryHome);
        Assert.assertEquals(1, view.getK());

        //We selected the academic year screen
        presenter.changeFragment(R.id.academicYearFragment);
        Assert.assertEquals(2, view.getK());

        //We selected the subject screen
        presenter.changeFragment(R.id.subjectFragment);
        Assert.assertEquals(3, view.getK());

        //We selected the offered subject screen
        presenter.changeFragment(R.id.offeredSubjectFragment);
        Assert.assertEquals(4, view.getK());

    }

    /**
     * We test to see if the grades are uploaded , according to the Date
     **/
    @Test
    public void updateGrades() {
        Set<Grade> grades = init.getGradeDAO().findAll();

        // The grades cannot be uploaded
        SystemDateStub date = new SystemDateStub();
        LocalDate now = LocalDate.of(2022, 10, 03);
        date.setStub(now);
        presenter.updateGrades();
        Assert.assertEquals(5, view.getK());
        Assert.assertEquals(19, grades.size());

        // The grades can be uploaded
        LocalDate now2 = LocalDate.of(2023, 6, 11);
        date.setStub(now2);
        presenter.updateGrades();
        Assert.assertEquals(5, view.getK());
        Assert.assertEquals(27, init.getGradeDAO().findAll().size());


    }


}
