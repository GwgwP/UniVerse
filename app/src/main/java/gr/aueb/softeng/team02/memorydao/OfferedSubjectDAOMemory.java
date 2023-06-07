package gr.aueb.softeng.team02.memorydao;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.OfferedSubject;

public class OfferedSubjectDAOMemory implements OfferedSubjectDAO {
    private static ArrayList<OfferedSubject> list = new ArrayList<>();

    @Override
    public void save(OfferedSubject entity) {
        if (!list.contains(entity)) {
            list.add(entity);
        }
    }

    @Override
    public void delete(OfferedSubject entity) {
        if (list.contains(entity))
            list.remove(entity);
    }

    @Override
    public List<OfferedSubject> findAll() {
        return new ArrayList<>(list);
    }

    @Override
    public List<OfferedSubject> findByModulo(int mod, String year) {
        ArrayList<OfferedSubject> subjects = new ArrayList<>();
        for (OfferedSubject subject : list) {
            if (subject.getSemester() % 2 == mod && subject.getAcademicYearINString().equals(year)) {
                subjects.add(subject);
            }
        }
        return subjects;
    }

    @Override
    public OfferedSubject findByYearAndName(String year, String title) {
        for (OfferedSubject subject : list) {
            if (subject.getTitle().equals(title) && subject.getAcademicYearINString().equals(year))
                return subject;
        }
        return null;
    }

    @Override
    public List<OfferedSubject> findAllSubjectsByYearAndBySemester(String year, int semester) {
        List<OfferedSubject> subjects = new ArrayList<>();
        for (OfferedSubject sub : list) {
            if (sub.getAcademicYearINString().equals(year) && sub.getSemester() == semester) {
                subjects.add(sub);
            }
        }
        return subjects;
    }

    @Override
    public List<OfferedSubject> findByYear(String year, int semester) {
        ArrayList<OfferedSubject> subjects = new ArrayList<>();

        for (OfferedSubject sub : list) {
            if (sub.getAcademicYearINString().equals(year) && sub.getSemester() == semester)
                subjects.add(sub);
        }
        return subjects;
    }

    @Override
    public OfferedSubject findByTitle(String title) {
        for (OfferedSubject sub : list) {
            if (sub.getTitle().equalsIgnoreCase(title)){
                return sub;
            }
        }

        return null;
    }
}
