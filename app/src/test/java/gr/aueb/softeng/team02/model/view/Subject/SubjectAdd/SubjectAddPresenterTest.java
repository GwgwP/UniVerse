package gr.aueb.softeng.team02.model.view.Subject.SubjectAdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Subject;
import gr.aueb.softeng.team02.view.Subject.SubjectAdd.SubjectFormPresenter;

public class SubjectAddPresenterTest {
    private Initializer init;
    private SubjectFormPresenter presenter;
    private SubjectAddViewStub view;

    private SubjectDAO dao;

    @Before
    public void setUp() throws AcademicYearException {
        init = new MemoryInitializer();
        init.prepareData();
        view = new SubjectAddViewStub();
        presenter = new SubjectFormPresenter(init.getSubjectDAO());
        presenter.setView(view);
        this.dao = init.getSubjectDAO();
    }

    @Test
    public void testGettersSetters() {
        ArrayList<String> prep = new ArrayList<>();
        prep.add("Philisophy");
        prep.add("Politics");

        view.setSubject("Art", "Romatics and Modern", "5", "Lydia Wallace");
        view.setPrerequisites(prep);
        // we test the getters for the subjects attributes
        Assert.assertEquals("Art", view.getSubTitle());
        Assert.assertEquals("Romatics and Modern", view.getDesc());
        Assert.assertEquals("Lydia Wallace", view.getProf());
        Assert.assertEquals(2, view.getSizePrerequisties());
        Assert.assertEquals("5", view.getEcts());

        //we test the X image getters
        view.setexEcts();
        Assert.assertEquals(true, view.getExEcts());

        view.invDesc();
        Assert.assertEquals(false, view.exDesc);

        view.setexTitle();
        Assert.assertEquals(true, view.getExTitle());

        view.invProf();
        Assert.assertEquals(false, view.getExProf());
    }

    @Test
    public void testIsNumber() {
        view.setSubject("Cats", "How to love cats", "t", "Lydia Wallace");
        boolean result = presenter.isNumber(view.getEcts());
        Assert.assertEquals(false, result);
    }

    @Test
    public void testAllWritten() {
        view.setSubject("Cats", "How to love cats", "9", "");
        presenter.setView(view);
        Assert.assertEquals(false, presenter.allWritten());
    }

    @Test
    public void testCreateSubject() {
        view.setSubject("Java", "How to love cats", "9", "Lydia Wallace");
        presenter.setView(view);
        presenter.createSubject();
        // we see if the correct message was printed
        Assert.assertEquals(2, view.getMessage());
        // we see if the subjects' attributes changed
        Subject save = this.dao.findSubject(view.getSubTitle());
        Assert.assertEquals("How to love cats", save.getDesc());
    }

    @Test
    public void testGetSubjects() {
        ArrayList<String> test = presenter.getSubjects();
        Assert.assertEquals(37, test.size());
    }

    @Test
    public void testMakeForm() {
        presenter.makeForm();
        Assert.assertEquals(37, view.getSizePrerequisties());
    }

    @Test
    public void testValid() {


        // Answer = 0 -> we want to keep the old version
        // Answer = 1 -> we want to save the new version
        // Version where everything is ok , but we already
        // have an old version and we want to save the new
        view.setSubject("Java", "How to love cats", "9", "Lydia Wallace");
        presenter.setView(view);
        view.setAnswser(1); // we want to save the new
        presenter.valid();

        Assert.assertEquals(2, view.getMessage());


        // Version where everything is ok , but we already
        // have an old version and we want to keep the old
        view.setSubject("Java", "How to love cats", "9", "Lydia Wallace");

        view.setAnswser(0);
        presenter.setView(view);
        presenter.valid();

        Assert.assertEquals(0, view.getMessage());

        // Version where not all the boxes are written(we forgot the prerequisites)
        view.setSubject("Java", "", "9", "Lydia Wallace");
        presenter.setView(view);

        presenter.valid();
        Assert.assertEquals(1, view.getMessage());

        // Version where the ects box contains a letter
        view.setSubject("Java", "How to love cats", "9l", "Lydia Wallace");
        presenter.setView(view);

        presenter.valid();
        Assert.assertEquals(3, view.getMessage());

        // Version where we add a new subject
        view.setSubject("Cats", "How to love cats", "9", "Lydia Wallace");
        presenter.setView(view);

        presenter.valid();
        Assert.assertEquals(1, view.getBackAtrib());
        Assert.assertEquals(2, view.getMessage());
    }

    @Test
    public void testErrorNotWritten() {
        // The title box is not written
        view.setSubject("", "How to love cats", "9", "Lydia Wallace");
        presenter.setView(view);

        presenter.valid();
        Assert.assertEquals(true, view.getExTitle());
        Assert.assertEquals(false, view.getExEcts());
        Assert.assertEquals(false, view.getExProf());
        Assert.assertEquals(false, view.getExDesc());


        // The desc box is not written
        SubjectAddViewStub view2 = new SubjectAddViewStub();
        view2.setSubject("Mini", "", "9", "Lydia Wallace");
        presenter.setView(view2);

        presenter.valid();
        Assert.assertEquals(true, view2.getExDesc());
        Assert.assertEquals(false, view2.getExTitle());
        Assert.assertEquals(false, view2.getExEcts());
        Assert.assertEquals(false, view2.getExProf());

        // The ects box is not written
        SubjectAddViewStub view3 = new SubjectAddViewStub();
        view3.setSubject("Mini", "How to love cats", "", "Lydia Wallace");
        presenter.setView(view3);

        presenter.valid();
        Assert.assertEquals(true, view3.getExEcts());
        Assert.assertEquals(false, view3.getExTitle());
        Assert.assertEquals(false, view3.getExProf());
        Assert.assertEquals(false, view3.getExDesc());

        // The professor box is not written
        SubjectAddViewStub view4 = new SubjectAddViewStub();
        view4.setSubject("Mini", "How to love cats", "9", "");
        presenter.setView(view4);

        presenter.valid();
        Assert.assertEquals(true, view4.getExProf());
        Assert.assertEquals(false, view4.getExDesc());
        Assert.assertEquals(false, view4.getExEcts());
        Assert.assertEquals(false, view4.getExTitle());
    }
}
