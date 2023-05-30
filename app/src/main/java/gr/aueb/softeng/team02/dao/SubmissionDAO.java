package gr.aueb.softeng.team02.dao;

import java.util.List;

import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.Submission;

public interface SubmissionDAO {
    public List<Submission> findAll();
    public List<Submission> findOfferedSubjectsInSubmissionPerYearAndStudent(int studentId, AcademicYear year, int semester);
    public void save(Submission entity);
    public void delete(Submission entity);
}
