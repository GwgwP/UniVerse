package gr.aueb.softeng.team02.view.Progress;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;


public class ProgressFragment extends Fragment implements ProgressView {

    private View view;

    private TextView txtAverageGrade;

    ProgressFragmentViewModel viewModel;
    private int student_id;
    private Initializer init;
    private ProgressPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_progress, container, false);
        Bundle bundle = getArguments();

        txtAverageGrade = view.findViewById(R.id.ag);

        this.student_id = bundle.getInt("STUDENT_ID", 0);
        this.init = new MemoryInitializer();


        viewModel = new ProgressFragmentViewModel(); //ViewModelProvider(this).get(ProgressFragmentViewModel.class);
        viewModel.getPresenter().setView(this);
        //ProgressPresenter presenter = viewModel.getPresenter();
        //presenter.setView(this);

        //presenter = new ProgressPresenter(this, init.getGradeDAO());
        return view;
    }
    @Override
    public void onStart()
    {
        super.onStart();
        viewModel.getPresenter().getAverage(student_id);

    }
//        BookReservationPresenter presenter = viewModel.getPresenter(); OTAN ALLAZEI OTHONI
//        presenter.setView(this);

//    private void searchBook() {
//        viewModel.getPresenter().getAverage(student_id);
//
///*
//            String bookTitle = edtBookTitle.getText().toString();
//            String authorName = edtAuthorName.getText().toString();
//            viewModel.getPresenter().search(bookTitle, authorName);*/
//    }

    @Override
    public void getGrade() {

    }

    public void showAverage(double avg) {
        txtAverageGrade.setText(String.valueOf(avg));

    }

      /*  private void reserveBook() {
            String borrowerId = edtBorrowerId.getText().toString();
            viewModel.getPresenter().submitReservationRequest(borrowerId);
        }
*/

}

