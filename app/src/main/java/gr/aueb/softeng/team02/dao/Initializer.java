package gr.aueb.softeng.team02.dao;

import gr.aueb.softeng.team02.model.Student;

public abstract class Initializer {

    protected abstract void eraseData();
    public abstract SecretaryDAO getSecretaryDAO();
    public abstract StudentDAO getStudentDAO();

    public void prepareData() {
        eraseData();
        SecretaryDAO secretaryDAO = getSecretaryDAO();
        StudentDAO studentDAO = getStudentDAO();

        studentDAO.save(new Student(3200125, "p3200125", "Irma", "Lydia-Christina", "Wallace", 6));
        studentDAO.save(new Student(3200155, "p3200155", "Well", "Georgia", "Petsa", 6));
        studentDAO.save(new Student(3200199, "p3200199", "Link", "Panagiotis", "Triantafillidis", 6));




    }
}
