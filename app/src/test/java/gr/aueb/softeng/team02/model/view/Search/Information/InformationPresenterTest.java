package gr.aueb.softeng.team02.model.view.Search.Information;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.view.Search.Information.InformationPresenter;


public class InformationPresenterTest {
    private Initializer init;
    private InformationPresenter presenter;
    private InformationViewStub view;

    @Before
    public void setUp() throws AcademicYearException {
        init = new MemoryInitializer();
        init.prepareData();
        view = new InformationViewStub();
        presenter = new InformationPresenter(init.getOfferedSubjectDAO());
        presenter.setView(view);

    }

    /**
     * We check to see if the information that the presenter got is correct
     * 1) A subject with no prerequisites
     * 2) A subject with prerequisites
     **/

    @Test
    public void testSetInfo() {
        presenter.setInfo("Algebra 1");
        Assert.assertEquals("Advanced Mathematics", view.getDesc());
        Assert.assertEquals("Algebra 1", view.getTitle());
        Assert.assertEquals(8, view.getEcts());
        Assert.assertEquals("Stauros Toumpis", view.getProf());
        Assert.assertEquals(0, view.getPrereSize());


        presenter.setInfo("Multimedia technology");
        Assert.assertEquals("Introduction on multimedia technology", view.getDesc());
        Assert.assertEquals("Multimedia technology", view.getTitle());
        Assert.assertEquals(8, view.getEcts());
        Assert.assertEquals("George Xulomenos", view.getProf());
        Assert.assertEquals(1, view.getPrereSize());
    }


}
