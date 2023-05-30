package gr.aueb.softeng.team02.memorydao;

import java.util.HashSet;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.DAOFactory;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.dao.SecretaryDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;
public class MemoryInitializer extends Initializer {
    public MemoryInitializer() {
        System.setProperty("daofactory", "gr.aueb.softeng.team02.memorydao.MemoryDAOFactory");
    }

    @Override
    protected void eraseData() {
        HashSet<Student> allStudents = getStudentDAO().findAll();
        for (Student student : allStudents)
            getStudentDAO().delete(student);

        HashSet<Secretary> allSecretaries = getSecretaryDAO().findAll();
        for (Secretary secretary: allSecretaries)
            getSecretaryDAO().delete(secretary);
    }

    @Override
    public SecretaryDAO getSecretaryDAO() {
        return DAOFactory.getFactory().getSecretaryDAO();
    }

    @Override
    public StudentDAO getStudentDAO() {
        return DAOFactory.getFactory().getStudentDAO();
    }

    @Override
    public AcademicYearDAO getAcademicYearDAO() {
        return DAOFactory.getFactory().getAcademicYearDAO();
    }
}
