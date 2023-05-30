package gr.aueb.softeng.team02.memorydao;

import java.util.HashSet;
import java.util.List;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.model.AcademicYear;

public class AcademicYearDAOMemory implements AcademicYearDAO {
    protected static HashSet<AcademicYear> entities = new HashSet<AcademicYear>();

    @Override
    public void save(AcademicYear entity) {
        if (!entities.contains(entity))
            entities.add(entity);
    }

    @Override
    public void delete(AcademicYear entity) {
        if (entities.contains(entity))
            entities.remove(entity);
    }

    @Override
    public AcademicYear find(String year) {
        for (AcademicYear acYear : entities) {
            if (acYear.getAc_year().equals(year))
                return acYear;
        }
        return null;
    }

    @Override
    public HashSet<AcademicYear> findAll() {
        return entities;
    }
}
