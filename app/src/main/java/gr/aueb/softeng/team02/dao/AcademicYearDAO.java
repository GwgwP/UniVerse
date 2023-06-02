package gr.aueb.softeng.team02.dao;

import java.util.HashSet;
import java.util.List;

import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Circumscription;

public interface AcademicYearDAO {
    public void save(AcademicYear entity);

    public void delete(AcademicYear entity);

    public AcademicYear find(String year);

    public Circumscription findCircumscriptionBySemesterAndYear(int semester, String year) throws AcademicYearException;

    public HashSet<AcademicYear> findAll();
}
