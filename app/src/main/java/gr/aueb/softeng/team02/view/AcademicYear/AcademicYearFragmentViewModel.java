package gr.aueb.softeng.team02.view.AcademicYear;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.memorydao.AcademicYearDAOMemory;
import gr.aueb.softeng.team02.memorydao.GradeDAOMemory;
import gr.aueb.softeng.team02.memorydao.OfferedSubjectDAOMemory;
import gr.aueb.softeng.team02.memorydao.StudentDAOMemory;
import gr.aueb.softeng.team02.memorydao.SubmissionDAOMemory;
import gr.aueb.softeng.team02.view.Submission.SubmissionFragmentPresenter;

public class AcademicYearFragmentViewModel extends ViewModel {

    AcademicYearFragmentPresenter presenter;
    public AcademicYearFragmentViewModel()
    {
        presenter = new AcademicYearFragmentPresenter(new AcademicYearDAOMemory());
    }

    public AcademicYearFragmentPresenter getPresenter(){return presenter;}

}
