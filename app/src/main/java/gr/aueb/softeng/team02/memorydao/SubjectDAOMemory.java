package gr.aueb.softeng.team02.memorydao;

import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.model.Subject;
import java.util.*;

public class SubjectDAOMemory implements SubjectDAO {

    static int id =0;
    private static List<Subject> entities = new ArrayList<>();
    @Override
    public List<Subject> findAll() { return new ArrayList<>(entities);}

    @Override
    public Subject findSubject(String title) {
        for (Subject subject : entities) {
            if (subject.getTitle().equals(title))
                return subject;
        }
        return null;
    }

    @Override
    public void save(Subject subject) {
        if (!this.entities.contains(subject)) {
            subject.setId(getNewId());
            this.entities.add(subject);
        }
    }

    @Override
    public void delete(Subject subject) {
        if (entities.contains(subject))
            entities.remove(subject);
    }

    @Override
    public int nextId() {
        return (entities.size() > 0 ? entities.get(entities.size()-1).getId()+1 : 1);
    }

    public boolean exists(String title){
        for(Subject k : entities){
            if(title.equalsIgnoreCase(k.getTitle())){
                return true;
            }
        }
        return false;
    }

    @Override
    public int getNewId() {
        return id++;
    }
}
