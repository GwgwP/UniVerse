package gr.aueb.softeng.team02.dao;

import gr.aueb.softeng.team02.memorydao.SecretaryDAOMemory;
import gr.aueb.softeng.team02.memorydao.StudentDAOMemory;
import gr.aueb.softeng.team02.memorydao.SubjectDAOMemory;
import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;
import gr.aueb.softeng.team02.model.Subject;

public class Initializer {

    static SecretaryDAO secretaryDAO;
    static StudentDAO studentDAO;

    static SubjectDAO subjectDao;
    protected void eraseData() {
        for (Secretary secretary : secretaryDAO.findAll()) {
            getSecretaryDAO().delete(secretary);
        }
        for (Student student : studentDAO.findAll()) {
            getStudentDAO().delete(student);
        }
    }

    public SecretaryDAO getSecretaryDAO()
    {
        return secretaryDAO;
    }

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void prepareData() {
        secretaryDAO = new SecretaryDAOMemory();
        studentDAO = new StudentDAOMemory();

        studentDAO.save(new Student(3200125, "p3200125", "Irma", "Lydia-Christina", "Wallace", 6));
        studentDAO.save(new Student(3200155, "p3200155", "Well", "Georgia", "Petsa", 6));
        studentDAO.save(new Student(3200199, "p3200199", "Link", "Panagiotis", "Triantafillidis", 6));

        secretaryDAO.save(new Secretary(12345, "p12345", "0000", "Eusta8ios", "Xaralampidhs"));

        subjectDao = new SubjectDAOMemory();
        subjectDao.save(new Subject(123, "ak", 5, "alalal", "title"));
    }
}
