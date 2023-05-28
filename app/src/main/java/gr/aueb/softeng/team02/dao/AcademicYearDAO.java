package gr.aueb.softeng.team02.dao;
import java.util.List;
import gr.aueb.softeng.team02.model.AcademicYear;

public interface AcademicYearDAO {
    public void save(AcademicYear entity);
    public void delete(AcademicYear entity);
    public AcademicYear find(String year);

    public List<AcademicYear> findAll();
}
