package gr.aueb.softeng.team02.memorydao;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.DAOFactory;
import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.dao.SecretaryDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.dao.SubmissionDAO;

public class MemoryDAOFactory extends DAOFactory {
    private StudentDAOMemory studentDAOMemory = new StudentDAOMemory();
    private SecretaryDAOMemory secretaryDAOMemory = new SecretaryDAOMemory();
    private AcademicYearDAOMemory academicYearDAOMemory = new AcademicYearDAOMemory();
    private SubjectDAOMemory subjectDAOMemory = new SubjectDAOMemory();
    private GradeDAOMemory gradeDAOMemory = new GradeDAOMemory();
    private OfferedSubjectDAOMemory offeredSubjectDAOMemory = new OfferedSubjectDAOMemory();
    private SubmissionDAOMemory submissionDAOMemory = new SubmissionDAOMemory();

    /**
     * Επιστρέφει το αντικείμενο για τη διεπαφή {@link StudentDAO}.
     *
     * @return Το αντικείμενο DAO.
     */
    @Override
    public StudentDAO getStudentDAO() {
        return studentDAOMemory;
    }

    /**
     * Επιστρέφει το αντικείμενο για τη διεπαφή {@link SecretaryDAO}.
     *
     * @return Το αντικείμενο DAO.
     */
    @Override
    public SecretaryDAO getSecretaryDAO() {
        return secretaryDAOMemory;
    }

    /**
     * Επιστρέφει το αντικείμενο για τη διεπαφή {@link AcademicYearDAO}.
     *
     * @return Το αντικείμενο DAO.
     */
    @Override
    public AcademicYearDAO getAcademicYearDAO() {
        return academicYearDAOMemory;
    }

    /**
     * Επιστρέφει το αντικείμενο για τη διεπαφή {@link SubjectDAO}.
     *
     * @return Το αντικείμενο DAO.
     */
    @Override
    public SubjectDAO getSubjectDAO() {
        return subjectDAOMemory;
    }

    /**
     * Επιστρέφει το αντικείμενο για τη διεπαφή {@link GradeDAO}.
     *
     * @return Το αντικείμενο DAO.
     */
    @Override
    public GradeDAO getGradeDAO() {
        return gradeDAOMemory;
    }

    /**
     * Επιστρέφει το αντικείμενο για τη διεπαφή {@link OfferedSubjectDAO}.
     *
     * @return Το αντικείμενο DAO.
     */
    @Override
    public OfferedSubjectDAO getOfferedSubjectDAO() {
        return offeredSubjectDAOMemory;
    }

    /**
     * Επιστρέφει το αντικείμενο για τη διεπαφή {@link SubmissionDAO}.
     *
     * @return Το αντικείμενο DAO.
     */
    @Override
    public SubmissionDAO getSubmissionDAO() {
        return submissionDAOMemory;
    }
}
