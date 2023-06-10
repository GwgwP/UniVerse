package gr.aueb.softeng.team02.model.view.Authentication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.Map;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.dao.SecretaryDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;
import gr.aueb.softeng.team02.model.User;
import gr.aueb.softeng.team02.view.Authentication.UserLoginPresenter;



public class AuthenticationPresenterTest {
    private Initializer init ;
    private AuthenticationViewStub view;
    private UserLoginPresenter presenter;

    private StudentDAO daoSt;
    private SecretaryDAO daoSe;

    @Before
    public void setUp()throws AcademicYearException {
        init = new MemoryInitializer();
        init.prepareData();
        view= new AuthenticationViewStub();
        this.presenter = new UserLoginPresenter(view, init.getStudentDAO(), init.getSecretaryDAO());
        this.daoSt= init.getStudentDAO();
        this.daoSe= init.getSecretaryDAO();
    }

    @Test
    public void testStartProcess(){
        // Version where the user has not written a username
        view.setUser("","Irma",0);
        presenter.startProcess();
        Assert.assertEquals(1, view.getName());

        //Version where the user has not written a password

        view.setUser("Lydia", "",0);
        presenter.startProcess();
        Assert.assertEquals(1,view.getPass());

        // Version where the user has not written password and username
        view.setUser("","",0);
        presenter.startProcess();
        Assert.assertEquals(2,view.getPass());
        Assert.assertEquals(2,view.getName());

        //Version where everything is checked and its a student
        view.setUser("p3200125", "Irma",0);
        presenter.startProcess();
        Assert.assertEquals(1,view.getStudent());

        //Version where everything is checked and its a secretary
        view.setUser("p12345","0000",1);
        presenter.startProcess();
        Assert.assertEquals(1,view.getSecretary());

        //Version where user not found
        view.setUser("p12345","0000",0);
        presenter.startProcess();
        Assert.assertEquals(1,view.message);


    }

    @Test
    public void testFindUser(){

        // the user is a student
        view.setRole(0);
        Map.Entry<Integer,User > student  = presenter.findUser("p3200125","Irma");
        Student k =  daoSt.findStudentByUsernameAndPassword("p3200125","Irma");
        boolean same = k.equals(student.getValue());
        Assert.assertEquals(true,same);

        //the user is secretary
        view.setRole(1);
        Map.Entry<Integer,User > secretary  = presenter.findUser("p12345","0000");
        Secretary s =  daoSe.findSecretary("p12345","0000");

        same = s.equals(secretary.getValue());
        Assert.assertEquals(true,same);


        // the user does not exist
        Map.Entry<Integer,User > none  = presenter.findUser("p12345","0001");
        int code = none.getKey();
        Assert.assertEquals(-1,code);

    }

}
