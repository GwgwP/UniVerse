package gr.aueb.softeng.team02.memorydao;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.DAOFactory;
import gr.aueb.softeng.team02.dao.SecretaryDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;

public class MemoryDAOFactory extends DAOFactory {
    private StudentDAOMemory studentDAOMemory = new StudentDAOMemory();
    private SecretaryDAOMemory secretaryDAOMemory = new SecretaryDAOMemory();
    private AcademicYearDAOMemory academicYearDAOMemory = new AcademicYearDAOMemory();

    @Override
    public StudentDAO getStudentDAO() {
        return studentDAOMemory;
    }

    @Override
    public SecretaryDAO getSecretaryDAO() {
        return secretaryDAOMemory;
    }

    @Override
    public AcademicYearDAO getAcademicYearDAO() {
        return academicYearDAOMemory;
    }
}
