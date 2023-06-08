package gr.aueb.softeng.team02.view.AcademicYear.AcademicYearForm;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.team02.memorydao.AcademicYearDAOMemory;

public class AcademicYearFragmentViewModel extends ViewModel {

    AcademicYearFragmentPresenter presenter;

    /**
     * Initializes the presenter
     */
    public AcademicYearFragmentViewModel()
    {
        presenter = new AcademicYearFragmentPresenter(new AcademicYearDAOMemory());
    }

    /**
     *
     * @return returns the presenter
     */
    public AcademicYearFragmentPresenter getPresenter(){return presenter;}

}
