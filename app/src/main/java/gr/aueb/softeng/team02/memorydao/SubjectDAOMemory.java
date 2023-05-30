package gr.aueb.softeng.team02.memorydao;

import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.model.Subject;
import java.util.*;

public class SubjectDAOMemory implements SubjectDAO {
    ArrayList<Subject> entities = new ArrayList<>();
    @Override
    public List<Subject> findAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public Subject findSubject(String title) {
        for (Subject subject : this.entities) {
            if (subject.getTitle().equals(title))
                return subject;
        }
        return null;
    }

    @Override
    public void save(Subject subject) {
        if (!this.entities.contains(subject))
            this.entities.add(subject);
    }

    @Override
    public void delete(Subject subject) {
        if (this.entities.contains(subject))
            this.entities.add(subject);
    }

    @Override
    public int nextId() {
        return (entities.size() > 0 ? entities.get(entities.size()-1).getId()+1 : 1);
    }
}
