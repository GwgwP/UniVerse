package gr.aueb.softeng.team02.memorydao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Circumscription;

public class AcademicYearDAOMemory implements AcademicYearDAO {
    protected static HashSet<AcademicYear> entities = new HashSet<AcademicYear>();
    protected static AcademicYear currentAcadYear;

    /**
     * Stores an Academic Year object
     *
     * @param entity the new Academic Year object
     */
    @Override
    public void save(AcademicYear entity) {
        if (!entities.contains(entity))
            entities.add(entity);
    }

    /**
     * Deletes an Academic Year
     *
     * @param entity an Academic year object
     */
    @Override
    public void delete(AcademicYear entity) {
        if (entities.contains(entity))
            entities.remove(entity);
    }

    /**
     * Get an Academic Year based on the time stamp string
     *
     * @param year the time stamp string
     * @return an Academic Year object or null
     */
    @Override
    public AcademicYear find(String year) {
        for (AcademicYear acYear : entities) {
            if (acYear.getAc_year().equals(year))
                return acYear;
        }
        return null;
    }

    /**
     * Get a Circumscription object of an academic year in a given semester
     *
     * @param semester the semester as an integer
     * @param year     the time stamp of the academic year
     * @return Circumscription object or null
     * @throws AcademicYearException if there is not a circumscription in the given semester
     */
    @Override
    public Circumscription findCircumscriptionBySemesterAndYear(int semester, String year) throws AcademicYearException {
        for (AcademicYear y : entities) {
            if (y.getAc_year().equals(year)) {
                return y.getCircumscription(semester);
            }
        }
        return null;
    }

    /**
     * Get all academic Year objects
     *
     * @return all academic years objects
     */
    @Override
    public Set<AcademicYear> findAll() {
        return new HashSet<>(entities);
    }

    /**
     * Set current academic year for the use cases : submission, grade uploading
     * Initialized in prepared data on Initializer
     *
     * @param ac Academic Year object
     */
    @Override
    public void setCurrentAcadYear(AcademicYear ac) {
        currentAcadYear = ac;
    }

    /**
     * Get current academic year
     *
     * @return current academic year object
     */
    @Override
    public AcademicYear getCurrentAcadYear() {
        return currentAcadYear;
    }
}