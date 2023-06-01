package gr.aueb.softeng.team02.memorydao;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.OfferedSubject;

public class OfferedSubjectDAOMemory implements OfferedSubjectDAO {
    private ArrayList<OfferedSubject> list = new ArrayList<>();

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
    public List<OfferedSubject> findByYear(String year, int semester) {
        ArrayList<OfferedSubject> subjects = new ArrayList<>();

        for (OfferedSubject sub : this.list) {
            if (sub.getAcademicYearINString().equals(year) && sub.getSemester() == semester)
                subjects.add(sub);
        }
        return subjects;
    }
}
