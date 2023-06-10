package gr.aueb.softeng.team02.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.dao.SubmissionDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.Submission;

public class SubmissionDAOMemory implements SubmissionDAO {
    private static ArrayList<Submission> submissions = new ArrayList<>();

    /**
     * Get the list of all submission from the dao
     *
     * @return a list of submission objects
     */
    @Override
    public List<Submission> findAll() {
        return new ArrayList<>(submissions);
    }

    /**
     * Saves the submission if it doesn't exist on the dao
     *
     * @param entity the submission object
     */
    @Override
    public void save(Submission entity) {
        if (!submissions.contains(entity))
            submissions.add(entity);
    }

    /**
     * Deletes the submission if it does exist on the dao
     *
     * @param entity the submission object
     */
    @Override
    public void delete(Submission entity) {
        submissions.remove(entity);
    }

    @Override
    public Submission findByAcademicYearAndSemesterAndStudentId(String year, int semester, int studentId) {
        for (Submission submission : submissions) {
            if (submission.getStudentId() == studentId && submission.getSemester() == semester && submission.getAcademicYear().getAc_year().equals(year))
                return submission;
        }
        return null;
    }

}
