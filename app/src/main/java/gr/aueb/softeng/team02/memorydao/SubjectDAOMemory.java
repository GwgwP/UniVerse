package gr.aueb.softeng.team02.memorydao;

import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.model.Subject;

import java.util.*;

public class SubjectDAOMemory implements SubjectDAO {

    static int id = 0;
    private static List<Subject> entities = new ArrayList<>();

    /**
     * Get a list of all subjects in the dao
     *
     * @return a list of subject list objects
     */
    @Override
    public List<Subject> findAll() {
        return new ArrayList<>(entities);
    }

    /**
     * Get subject based on the title
     *
     * @param title the title of the subject as a string
     * @return a subject object or null
     */
    @Override
    public Subject findSubject(String title) {
        for (Subject subject : entities) {
            if (subject.getTitle().equals(title))
                return subject;
        }
        return null;
    }

    /**
     * Save the subject if it doesn't exist in the dao
     *
     * @param subject the subject object
     */
    @Override
    public void save(Subject subject) {
        if (!entities.contains(subject)) {
            subject.setId(getNewId());
            entities.add(subject);
        }
    }

    /**
     * Delete the subject if it does exist in the dao
     *
     * @param subject the subject object
     */
    @Override
    public void delete(Subject subject) {
        if (entities.contains(subject))
            entities.remove(subject);
    }

    /**
     * Looks if a subject exists based on the title
     *
     * @param title the title of the subject as a string
     * @return an answer that takes the values true or false
     */
    public boolean exists(String title) {
        for (Subject k : entities) {
            if (title.equalsIgnoreCase(k.getTitle())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add the next id as an integer for the new subject
     *
     * @return a new id
     */
    @Override
    public int getNewId() {
        return ++id;
    }
}
