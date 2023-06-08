package gr.aueb.softeng.team02.dao;

import java.util.List;

import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.Submission;

public interface SubmissionDAO {
    /**
     * Get the list of all submission from the dao
     *
     * @return a list of submission objects
     */
    public List<Submission> findAll();

    /**
     * Saves the submission if it doesn't exist on the dao
     *
     * @param entity the submission object
     */
    public void save(Submission entity);

    /**
     * Deletes the submission if it does exist on the dao
     *
     * @param entity the submission object
     */
    public void delete(Submission entity);
}
