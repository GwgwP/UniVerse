package gr.aueb.softeng.team02.view.Progress;
import java.util.Map;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;
import gr.aueb.softeng.team02.model.User;
import gr.aueb.softeng.team02.view.Home;

public class ProgressActivity implements ProgressView {
    private ProgressPresenter presenter;

    private Initializer init;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.progress);
//        setTitle("Progress");
//        init = new MemoryInitializer();
//        try {
//            init.prepareData();
//        } catch (AcademicYearException e) {
//            Log.e("DEBUGGER", "Fault");
//            throw new RuntimeException(e);
//        }
//        presenter = new ProgressPresenter(this, init.getOfferedSubjectDAO()DAO());
//    }

    @Override
    public void getGrade() {

    }
}