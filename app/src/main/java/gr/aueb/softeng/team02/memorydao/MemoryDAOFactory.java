package gr.aueb.softeng.team02.memorydao;

import gr.aueb.softeng.team02.dao.DAOFactory;
import gr.aueb.softeng.team02.dao.SecretaryDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;

public class MemoryDAOFactory extends DAOFactory {
    private StudentDAOMemory studentDAOMemory = new StudentDAOMemory();
    private SecretaryDAOMemory secretaryDAOMemory = new SecretaryDAOMemory();


    @Override
    public StudentDAO getStudentDAO() {
        return studentDAOMemory;
    }

    @Override
    public SecretaryDAO getSecretaryDAO() {
        return secretaryDAOMemory;
    }
}
