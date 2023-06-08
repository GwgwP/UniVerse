package gr.aueb.softeng.team02.view.Submission;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.memorydao.AcademicYearDAOMemory;
import gr.aueb.softeng.team02.memorydao.GradeDAOMemory;
import gr.aueb.softeng.team02.memorydao.OfferedSubjectDAOMemory;
import gr.aueb.softeng.team02.memorydao.StudentDAOMemory;
import gr.aueb.softeng.team02.memorydao.SubjectDAOMemory;
import gr.aueb.softeng.team02.memorydao.SubmissionDAOMemory;

public class SubmissionFragmentViewModel extends ViewModel {
    SubmissionFragmentPresenter presenter;

    /**
     * Initialize the presenter
     */
    public SubmissionFragmentViewModel() {
        presenter = new SubmissionFragmentPresenter(new AcademicYearDAOMemory(), new OfferedSubjectDAOMemory(), new StudentDAOMemory(), new GradeDAOMemory(), new SubmissionDAOMemory(), new SubjectDAOMemory());
    }

    /**
     *  Returns the main presenter
     * @return presenter
     */
    public SubmissionFragmentPresenter getPresenter() {
        return presenter;
    }
}
