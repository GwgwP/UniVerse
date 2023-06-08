package gr.aueb.softeng.team02.view.AcademicYear.AcademicYearForm;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.team02.memorydao.AcademicYearDAOMemory;

public class AcademicYearFragmentViewModel extends ViewModel {

    AcademicYearFragmentPresenter presenter;
    public AcademicYearFragmentViewModel()
    {
        presenter = new AcademicYearFragmentPresenter(new AcademicYearDAOMemory());
    }

    public AcademicYearFragmentPresenter getPresenter(){return presenter;}

}
