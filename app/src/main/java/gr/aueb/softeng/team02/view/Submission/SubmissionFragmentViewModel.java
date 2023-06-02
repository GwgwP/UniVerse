package gr.aueb.softeng.team02.view.Submission;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.memorydao.AcademicYearDAOMemory;
import gr.aueb.softeng.team02.memorydao.OfferedSubjectDAOMemory;
import gr.aueb.softeng.team02.memorydao.StudentDAOMemory;

public class SubmissionFragmentViewModel extends ViewModel {
    SubmissionFragmentPresenter presenter;

    public SubmissionFragmentViewModel() {
        presenter = new SubmissionFragmentPresenter(new AcademicYearDAOMemory(), new OfferedSubjectDAOMemory(), new StudentDAOMemory());
    }

    public SubmissionFragmentPresenter getPresenter() {
        return presenter;
    }
}
