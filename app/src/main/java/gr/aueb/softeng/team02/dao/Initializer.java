package gr.aueb.softeng.team02.dao;

import gr.aueb.softeng.team02.memorydao.SecretaryDAOMemory;
import gr.aueb.softeng.team02.memorydao.StudentDAOMemory;
import gr.aueb.softeng.team02.memorydao.SubjectDAOMemory;
import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;
import gr.aueb.softeng.team02.model.Subject;

public abstract class Initializer {


    static SecretaryDAO secretaryDAO;
    static StudentDAO studentDAO;

    static SubjectDAO subjectDao;

    //διαγράφουμε όλα τα δεδομένα στη βάση δεδομένων
    protected abstract void eraseData();

    public abstract SecretaryDAO getSecretaryDAO();

    public abstract StudentDAO getStudentDAO();

    public abstract AcademicYearDAO getAcademicYearDAO();

    public void prepareData() {
        Student s1 = new Student(3200125, "p3200125", "Irma", "Lydia-Christina", "Wallace", 6);
        Student s2 = new Student(3200155, "p3200155", "Well", "Georgia", "Petsa", 6);
        Student s3 = new Student(3200199, "p3200199", "Link", "Panagiotis", "Triantafillidis", 6);

        Secretary r1 = new Secretary(12345, "p12345", "0000", "Eusta8ios", "Xaralampidhs");


        secretaryDAO.save(new Secretary(12345, "p12345", "0000", "Eusta8ios", "Xaralampidhs"));

        subjectDao = new SubjectDAOMemory();
        subjectDao.save(new Subject(123, "ak", 5, "alalal", "title"));

        getStudentDAO().save(s1);
        getStudentDAO().save(s2);
        getStudentDAO().save(s3);

        getSecretaryDAO().save(r1);

    }
}
