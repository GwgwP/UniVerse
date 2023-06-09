package gr.aueb.softeng.team02.model.view.Subject.SubjectFragment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;

import gr.aueb.softeng.team02.view.Subject.SubjectFragment.SubjectPresenter;

public class SubjectPresenterTest {

    private Initializer init;
    private SubjectPresenter presenter;
    private SubjectViewStub view;
    @Before
    public void setUp() throws AcademicYearException {
        init = new MemoryInitializer();

        init.prepareData();
        view = new SubjectViewStub();

        presenter = new SubjectPresenter(init.getSubjectDAO());
        presenter.setView(view);
    }

    @Test
    public void testShowSub(){ // we need to see how many subjects it shows
        presenter.showSub();
        // we have 36 subjects
        Assert.assertEquals(36, view.getSize());

    }

}
