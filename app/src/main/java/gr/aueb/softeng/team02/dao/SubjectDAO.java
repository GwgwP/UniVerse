package gr.aueb.softeng.team02.dao;

import gr.aueb.softeng.team02.model.Subject;

import java.util.*;

public interface SubjectDAO {
    /**
     * Get a list of all subjects in the dao
     *
     * @return a list of subject list objects
     */
    public List<Subject> findAll();

    /**
     * Get subject based on the title
     *
     * @param title the title of the subject as a string
     * @return a subject object or null
     */
    public Subject findSubject(String title);

    /**
     * Save the subject if it doesn't exist in the dao
     *
     * @param subject the subject object
     */
    public void save(Subject subject);

    /**
     * Delete the subject if it does exist in the dao
     *
     * @param subject the subject object
     */
    public void delete(Subject subject);

    /**
     * Looks if a subject exists based on the title
     *
     * @param title the title of the subject as a string
     * @return an answer that takes the values true or false
     */
    public boolean exists(String title);

    /**
     * Add the next id as an integer for the new subject
     *
     * @return a new id
     */
    public int getNewId();

}
