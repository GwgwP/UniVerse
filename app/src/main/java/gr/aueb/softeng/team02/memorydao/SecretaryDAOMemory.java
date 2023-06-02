package gr.aueb.softeng.team02.memorydao;

import android.util.Log;

import java.util.HashSet;

import gr.aueb.softeng.team02.dao.SecretaryDAO;
import gr.aueb.softeng.team02.model.Secretary;

public class SecretaryDAOMemory implements SecretaryDAO {

    protected static HashSet<Secretary> entities = new HashSet<>();

    @Override
    public HashSet<Secretary> findAll() {
        return new HashSet<>(entities);
    }

    @Override
    public Secretary findSecretary(String username, String password) {
        for (Secretary secretary : this.entities) {
            if (secretary.getUsername().equals(username) && secretary.getPassword().equals(password))
                return secretary;
        }
        return null;
    }

    @Override
    public void save(Secretary secretary) {
        if (!entities.contains(secretary))
            entities.add(secretary);
    }

    @Override
    public void delete(Secretary secretary) {
        if (entities.contains(secretary))
            entities.add(secretary);
    }
}
