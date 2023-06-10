package gr.aueb.softeng.team02.memorydao;

import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import gr.aueb.softeng.team02.dao.SecretaryDAO;
import gr.aueb.softeng.team02.model.Secretary;

public class SecretaryDAOMemory implements SecretaryDAO {

    protected static HashSet<Secretary> entities = new HashSet<>();

    /**
     * Get all secretaries as a set
     *
     * @return a set of secretery objects
     */
    @Override
    public Set<Secretary> findAll() {
        return new HashSet<>(entities);
    }

    /**
     * Get a secretary based on the username and password
     *
     * @param username the username of the secretary as a string
     * @param password the password of the secretary as a string
     * @return a secretary object or null
     */
    @Override
    public Secretary findSecretary(String username, String password) {
        for (Secretary secretary : this.entities) {
            if (secretary.getUsername().equals(username) && secretary.getPassword().equals(password))
                return secretary;
        }
        return null;
    }

    /**
     * Save the secretary if it doesn't exist on the dao
     *
     * @param secretary the secretary object
     */
    @Override
    public void save(Secretary secretary) {
        if (!entities.contains(secretary))
            entities.add(secretary);
    }

    /**
     * Delete the secretary if it does exist in the dao
     *
     * @param secretary the secretary object
     */
    @Override
    public void delete(Secretary secretary) {
        if (entities.contains(secretary))
            entities.remove(secretary);
    }
}
