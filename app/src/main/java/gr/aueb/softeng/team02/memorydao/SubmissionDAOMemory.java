package gr.aueb.softeng.team02.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.dao.SubmissionDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.Submission;

public class SubmissionDAOMemory implements SubmissionDAO {
    private static ArrayList<Submission> submissions = new ArrayList<>();

    @Override
    public List<Submission> findAll() {
        return new ArrayList<>(submissions);
    }

    @Override
    public List<Submission> findOfferedSubjectsInSubmissionPerYearAndStudent(int studentId, AcademicYear year, int semester) {
        ArrayList<Submission> stud_sem_submissions = new ArrayList<>();
        for (Submission submission : submissions) {
            if (submission.getStudentId() == studentId && submission.getAcademicYear().equals(year) && submission.getSemester() == semester) {
                stud_sem_submissions.add(submission);
            }
        }
        return stud_sem_submissions;
    }

    @Override
    public void save(Submission entity) {
        if (!submissions.contains(entity))
            submissions.add(entity);
    }

    @Override
    public void delete(Submission entity) {
        if (submissions.contains(entity))
            submissions.remove(entity);
    }
}
