package gr.aueb.softeng.team02.dao;

import java.util.HashSet;
import java.util.Set;

import gr.aueb.softeng.team02.model.Secretary;

public interface SecretaryDAO {

    public Set<Secretary> findAll();
    public Secretary findSecretary(String username, String password);
    public void save(Secretary student);
    public void delete(Secretary student);
}
