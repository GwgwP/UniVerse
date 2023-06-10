package gr.aueb.softeng.team02.model.view.Search.SearchFragment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.view.Subject.SubjectFragment.SubjectPresenter;


public class SearchFragmentPresenterTest {

    private SubjectPresenter presenter;
    private SeachFragmentViewStub view;
    private Initializer init;

    @Before
    public void setUp()throws AcademicYearException {
        init = new MemoryInitializer();
        init.prepareData();
        view= new SeachFragmentViewStub();
        presenter = new SubjectPresenter(init.getSubjectDAO());
        presenter.setView(view);

    }
    @Test
    public void testShowSub(){
        presenter.showSub();
        Assert.assertEquals(36,view.getNames());

    }
    @Test
    public void testAddForm(){
        presenter.addForm();
        Assert.assertEquals(1,view.k);

    }


}
