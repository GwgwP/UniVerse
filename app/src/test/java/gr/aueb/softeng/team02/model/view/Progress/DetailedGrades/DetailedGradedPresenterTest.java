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
        init.prepareData();
        grades = init.getGradeDAO();
        view = new DetailedGradesViewStub();
        presenter = new DetailedGradesPresenter(view, grades);
    }
    @Test
    public void Test1()
    {
        presenter.setStudentId(3200125);
        view.setStudent_id(3200125);
        view.receiveAverages();
        Assert.assertEquals(1, view.getReceived_avgs());

        Assert.assertEquals(3200125, view.getStudent_id());
        double av1=0, av2=0, av3=0, av4=0, av5=0, av6=0, av7=0, av8 =0;
        double counter =0.f;
        for (Grade g: grades.findBySemesterSubjects(view.getStudent_id(), 1))
        {
            if(g.getGrade()>=5)
            {
                av1+= g.getGrade();
                counter++;
            }
        }

        if(counter>0) {
            av1 = av1 / counter;
            view.setSem1(av1);
        }
        else
            view.setSem1(0.0);
        counter = 0.f;
        for (Grade g: grades.findBySemesterSubjects(view.getStudent_id(), 2))
        {
            if(g.getGrade()>=5)
            {
                av2+= g.getGrade();
                counter++;
            }
        }
        if(counter>0) {
            av2 = av2 / counter;
            view.setSem2(av2);
        }
        else
            view.setSem2(0.0);


// Semester 3
        counter = 0.0;
        for (Grade g : grades.findBySemesterSubjects(view.getStudent_id(), 3)) {
            if (g.getGrade() >= 5) {
                av3 += g.getGrade();
                counter++;
            }
        }
        if (counter > 0) {
            av3 /= counter;
            view.setSem3(av3);
        } else {
            view.setSem3(0.0);
        }

// Semester 4
        counter = 0.0;
        for (Grade g : grades.findBySemesterSubjects(view.getStudent_id(), 4)) {
            if (g.getGrade() >= 5) {
                av4 += g.getGrade();
                counter++;
            }
        }
        if (counter > 0) {
            av4 /= counter;
            view.setSem4(av4);
        } else {
            view.setSem4(0.0);
        }

// Semester 5
        counter = 0.0;
        for (Grade g : grades.findBySemesterSubjects(view.getStudent_id(), 5)) {
            if (g.getGrade() >= 5) {
                av5 += g.getGrade();
                counter++;
            }
        }
        if (counter > 0) {
            av5 /= counter;
            view.setSem5(av5);
        } else {
            view.setSem5(0.0);
        }

// Semester 6
        counter = 0.0;
        for (Grade g : grades.findBySemesterSubjects(view.getStudent_id(), 6)) {
            if (g.getGrade() >= 5) {
                av6 += g.getGrade();
                counter++;
            }
        }
        if (counter > 0) {
            av6 /= counter;
            view.setSem6(av6);
        } else {
            view.setSem6(0.0);
        }

// Semester 7
        counter = 0.0;
        for (Grade g : grades.findBySemesterSubjects(view.getStudent_id(), 7)) {
            if (g.getGrade() >= 5) {
                av7 += g.getGrade();
                counter++;
            }
        }
        if (counter > 0) {
            av7 /= counter;
            view.setSem7(av7);
        } else {
            view.setSem7(0.0);
        }

// Semester 8
        counter = 0.0;
        for (Grade g : grades.findBySemesterSubjects(view.getStudent_id(), 8)) {
            if (g.getGrade() >= 5) {
                av8 += g.getGrade();
                counter++;
            }
        }
        if (counter > 0) {
            av8 /= counter;
            view.setSem8(av8);
        }

        presenter.initSubView();
        Assert.assertEquals(1, view.getNum_of_shown_subjs());

        Assert.assertEquals(8.2, view.getSem1(), 0.0005);
        Assert.assertEquals(9, view.getSem2(), 0.0005);
        Assert.assertEquals(0, view.getSem3(), 0.0005);
        Assert.assertEquals(0, view.getSem4(), 0.0005);
        Assert.assertEquals(0, view.getSem5(), 0.0005);
        Assert.assertEquals(0, view.getSem6(), 0.0005);
        Assert.assertEquals(0, view.getSem7(), 0.0005);
        Assert.assertEquals(0, view.getSem8(), 0.0005);

        HashMap<Integer, HashMap<String, Integer>> gradingsradingss = new HashMap<>();

        for (int i = 1; i <= 8; i++) {

            HashMap<String, Integer> semesterSubjects = new HashMap<>();

            for (Grade g : grades.findBySemesterSubjects(view.getStudent_id(), i)) {
                semesterSubjects.put(g.getTitle(), g.getGrade());
            }

            gradingsradingss.put(i, semesterSubjects);
        }
        view.setGradings(gradingsradingss);
        Assert.assertEquals(8,view.getGradings().size());
        Assert.assertEquals(5, view.getGradings().get(1).size());
        Assert.assertEquals(5, view.getGradings().get(2).size());
        Assert.assertEquals(0, view.getGradings().get(3).size());
        Assert.assertEquals(0, view.getGradings().get(4).size());
        Assert.assertEquals(0, view.getGradings().get(5).size());
        Assert.assertEquals(0, view.getGradings().get(6).size());
        Assert.assertEquals(0, view.getGradings().get(7).size());
        Assert.assertEquals(0, view.getGradings().get(8).size());
    }



}
