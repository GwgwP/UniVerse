package gr.aueb.softeng.team02.memorydao;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.dao.SecretaryDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;

public class InitializerMemory extends Initializer {
    @Override
    protected void eraseData() {
        for (Secretary secretary : getSecretaryDAO().findAll()) {
            getSecretaryDAO().delete(secretary);
        }
        for (Student student : getStudentDAO().findAll()) {
            getStudentDAO().delete(student);
        }
    }

    @Override
    public SecretaryDAO getSecretaryDAO() {
        return new SecretaryDAOMemory();
    }

    @Override
    public StudentDAO getStudentDAO() {
        return new StudentDAOMemory();
    }
}
