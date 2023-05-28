package gr.aueb.softeng.team02.memorydao;

import java.util.HashSet;

import gr.aueb.softeng.team02.model.*;
import gr.aueb.softeng.team02.dao.*;

public class UserDAOMemory implements UserDAO {
    HashSet<User> entities = new HashSet<>();
    @Override
    public User findUser(String username, String password) {
        for (User user : this.entities) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    @Override
    public void save(User entity) {
        if (! entities.contains(entity))
            entities.add(entity);
    }

    @Override
    public void delete(User entity) {
        if (entities.contains(entity))
            entities.remove(entity);
    }

}
