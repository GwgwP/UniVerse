package gr.aueb.softeng.team02.dao;

import java.util.List;

import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.OfferedSubject;

public interface OfferedSubjectDAO {
    /**
     * Store the offered subject if it doesn't exist in the dao
     *
     * @param entity offered subject object
     */
    public void save(OfferedSubject entity);

    /**
     * Delete the offered subject if it does exist in the dao
     *
     * @param entity offered subject object
     */
    public void delete(OfferedSubject entity);

    /**
     * Get a list with all offered subjects in the dao
     *
     * @return a list of offered subject objects
     */
    public List<OfferedSubject> findAll();

    /**
     * Get a list of offered subject based on the modulo of the semester (even or odd number)
     *
     * @param mod  result of modulo is 0 or 1
     * @param year specific academic year object
     * @return a list of offered subject objects
     */
    public List<OfferedSubject> findByModulo(int mod, String year);

    /**
     * Get an offered subject based on the time stamp of an academic year
     *
     * @param year the time stamp of the academic year in string
     * @return an offered subject object or null
     */
    public List<OfferedSubject> findByYear(String year);

    /**
     * Get an offered subject based on a specific academic year time stamp and the subject title
     *
     * @param year  the time stamp of an academic year in a string
     * @param title the title of a subject as a string
     * @return an offered subject object if it does exist in the dao or null
     */
    public OfferedSubject findByYearAndName(String year, String title);

    /**
     * Get a list of offered subjects based on the semester abd the time stamp of the academic year
     *
     * @param year     the time stamp of the academic year in string
     * @param semester the semester as an integer
     * @return a list of offered subject objects
     */
    public List<OfferedSubject> findAllSubjectsByYearAndBySemester(String year, int semester);

    /**
     * Get an offered subject based on the title of it's subject
     *
     * @param title the title of the subject as a string
     * @return an offered subject object or null
     */
    public OfferedSubject findByTitle(String title);
}
