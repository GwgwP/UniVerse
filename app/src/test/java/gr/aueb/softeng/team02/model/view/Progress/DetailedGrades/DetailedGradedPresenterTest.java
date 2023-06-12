package gr.aueb.softeng.team02.model.view.Progress.DetailedGrades;

import android.service.voice.VoiceInteractionSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Grade;
import gr.aueb.softeng.team02.view.Progress.DetailedGrades.DetailedGradesPresenter;

public class DetailedGradedPresenterTest {
    private Initializer init;
    private DetailedGradesPresenter presenter;
    private DetailedGradesViewStub view;
    private GradeDAO grades;

    @Before
    public void setUp() throws AcademicYearException {
        init = new MemoryInitializer();
        init.prepareData(); // this line throws academic year exception but we know that it will not
        grades = init.getGradeDAO();
        view = new DetailedGradesViewStub();
        presenter = new DetailedGradesPresenter(view, grades);
    }

    /**
     * This is a Test for checking if every Dynamic List has the correct size of
     * subjects for the related students
     */
    @Test
    public void Testing_subjects()
    {
        presenter.setStudentId(3200125);
        view.setStudent_id(3200125);

        view.receiveAverages();
        Assert.assertEquals(1, view.getReceived_avgs());
        Assert.assertEquals(3200125, view.getStudent_id());

        presenter.initSubView();
        Assert.assertEquals(5, view.getGradings().get(1).size()); //checking that we have 5 subjects inside
        Assert.assertEquals(5, view.getGradings().get(2).size()); //checking that we have 5 subjects inside
        Assert.assertEquals(4, view.getGradings().get(3).size()); //checking that we have 0 subjects inside
        Assert.assertEquals(0, view.getGradings().get(4).size()); //checking that we have 0 subjects inside
        Assert.assertEquals(0, view.getGradings().get(5).size()); //checking that we have 0 subjects inside
        Assert.assertEquals(0, view.getGradings().get(6).size()); //checking that we have 0 subjects inside
        Assert.assertEquals(0, view.getGradings().get(7).size()); //checking that we have 0 subjects inside
        Assert.assertEquals(0, view.getGradings().get(8).size()); //checking that we have 0 subjects inside


        Assert.assertEquals("8", view.getGradings().get(1).get("Algebra 1").toString());
        Assert.assertEquals("9", view.getGradings().get(1).get("Python").toString());
        Assert.assertEquals("5", view.getGradings().get(1).get("Economics 1").toString());
        Assert.assertEquals("10", view.getGradings().get(1).get("Computer Science").toString());
        Assert.assertEquals("9", view.getGradings().get(1).get("Discrete Mathematics").toString());

        Assert.assertEquals("9", view.getGradings().get(2).get("Java").toString());
        Assert.assertEquals("9", view.getGradings().get(2).get("Design and analysis of digital systems").toString());
        Assert.assertEquals("9", view.getGradings().get(2).get("Linear Algebra").toString());
        Assert.assertEquals("9", view.getGradings().get(2).get("Possibilities").toString());
        Assert.assertEquals("9", view.getGradings().get(2).get("Business Management").toString());Assert.assertEquals("9", view.getGradings().get(2).get("Java").toString());

        Assert.assertEquals("5", view.getGradings().get(3).get("Computer systems organization").toString());
        Assert.assertEquals("4", view.getGradings().get(3).get("C++").toString());
        Assert.assertEquals("5", view.getGradings().get(3).get("Data structures").toString());
        Assert.assertEquals("5", view.getGradings().get(3).get("Computational mathematics").toString());


    }



}
