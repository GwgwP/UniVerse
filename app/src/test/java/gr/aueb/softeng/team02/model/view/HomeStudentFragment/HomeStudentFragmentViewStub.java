package gr.aueb.softeng.team02.model.view.HomeStudentFragment;


import gr.aueb.softeng.team02.view.HomeStudentFragment.StudentHomeView;

public class HomeStudentFragmentViewStub implements StudentHomeView {

    int k = 0;
    @Override
    public void logout() {
        k++;
    }
    public int getK(){
        return k ;
    }
}
