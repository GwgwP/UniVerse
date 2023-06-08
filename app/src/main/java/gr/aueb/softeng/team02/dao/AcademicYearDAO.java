package gr.aueb.softeng.team02.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Circumscription;

public interface AcademicYearDAO {
    /**
     * Stores an Academic Year object
     *
     * @param entity the new Academic Year object
     */
    public void save(AcademicYear entity);

    /**
     * Deletes an Academic Year
     *
     * @param entity an Academic year object
     */
    public void delete(AcademicYear entity);

    /**
     * Get an Academic Year based on the time stamp string
     *
     * @param year the time stamp string
     * @return an Academic Year object or null
     */
    public AcademicYear find(String year);

    /**
     * Get a Circumscription object of an academic year in a given semester
     *
     * @param semester the semester as an integer
     * @param year     the time stamp of the academic year
     * @return Circumscription object or null
     * @throws AcademicYearException if there is not a circumscription in the given semester
     */
    public Circumscription findCircumscriptionBySemesterAndYear(int semester, String year) throws AcademicYearException;

    /**
     * Get all academic Year objects
     *
     * @return all academic years objects
     */
    public Set<AcademicYear> findAll();

    /**
     * Set current academic year for the use cases : submission, grade uploading
     * Initialized in prepared data on Initializer
     *
     * @param ac Academic Year object
     */
    public void setCurrentAcadYear(AcademicYear ac);

    /**
     * Get current academic year
     *
     * @return current academic year object
     */
    public AcademicYear getCurrentAcadYear();
}
