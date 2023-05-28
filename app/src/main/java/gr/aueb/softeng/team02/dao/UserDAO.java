package gr.aueb.softeng.team02.dao;

import java.util.*;
import gr.aueb.softeng.team02.model.*;

public interface UserDAO {
    public User findUser(String username, String password);

    public void save(User entity);

    public void delete(User entity);
}
