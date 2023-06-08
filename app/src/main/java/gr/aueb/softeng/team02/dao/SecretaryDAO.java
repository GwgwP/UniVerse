package gr.aueb.softeng.team02.dao;

import java.util.HashSet;
import java.util.Set;

import gr.aueb.softeng.team02.model.Secretary;

public interface SecretaryDAO {
    /**
     * Get all secretaries as a set
     *
     * @return a set of secretery objects
     */
    public Set<Secretary> findAll();

    /**
     * Get a secretary based on the username and password
     *
     * @param username the username of the secretary as a string
     * @param password the password of the secretary as a string
     * @return a secretary object or null
     */
    public Secretary findSecretary(String username, String password);

    /**
     * Save the secretary if it doesn't exist on the dao
     *
     * @param secretary the secretary object
     */
    public void save(Secretary secretary);

    /**
     * Delete the secretary if it does exist in the dao
     *
     * @param secretary the secretary object
     */
    public void delete(Secretary secretary);
}
