package gr.aueb.softeng.team02.view.Progress;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import gr.aueb.softeng.team02.memorydao.GradeDAOMemory;

public class ProgressFragmentViewModel extends ViewModel {

    private ProgressPresenter presenter;

    public ProgressFragmentViewModel() {
        presenter = new ProgressPresenter();
        presenter.setGradesDao(new GradeDAOMemory());
    }

    public ProgressPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("ProgressPresenterVM", "On Cleared");
    }
}
