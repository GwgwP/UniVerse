package gr.aueb.softeng.team02.model.view.Subject.SubjectAdd;

import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.view.Subject.SubjectAdd.SubjectFormPresenter;

public class SubjectAddPresenterTest {
    private Initializer init;
    private SubjectFormPresenter presenter;
    private SubjectAddViewStub view;
    @Before
    public void setUp() throws AcademicYearException {
        init = new MemoryInitializer();
        init.prepareData();
        view = new SubjectAddViewStub();
        presenter = new SubjectFormPresenter(init.getSubjectDAO());
        presenter.setView(view);


    }
    public void  testGettersSetters(){
        ArrayList<String > prep = new ArrayList<>() ;
                prep.add("Philisophy");
                prep.add("Politics");

        view.setSubject("Art","Romatics and Modern","5","Lydia Wallace");

        // we test the getters for the subjects attributes
        Assert.assertEquals("Art",view.getSubTitle());
        Assert.assertEquals("Romatics and Modern",view.getDesc());
        Assert.assertEquals("Lydia Wallace",view.getProf());
        Assert.assertEquals(2,view.getSizePrerequisties());
        Assert.assertEquals("5",view.getEcts());

        //we test the X image getters
        view.setexEcts();
        Assert.assertEquals(true,view.getExEcts());

        view.invDesc();
        Assert.assertEquals(false,view.exDesc);

        view.setexTitle();
        Assert.assertEquals(false,view.getExTitle());

        view.invProf();
        Assert.assertEquals(false,view.getExProf());
    }

    public void testIsNumber(){
        view.setSubject("Cats","How to love cats","t","Lydia Wallace");


        boolean result = presenter.isNumber(view.getEcts());
        Assert.assertEquals(false,result);

    }

    public void testAllWritten(){
        view.setSubject("Cats","How to love cats","9","");
        presenter.setView(view);

        Assert.assertEquals(false,presenter.allWritten());
    }

    public void testCreateSubject(){
        view.setSubject("Java","How to love cats","9","Lydia Wallace");

    }

}
