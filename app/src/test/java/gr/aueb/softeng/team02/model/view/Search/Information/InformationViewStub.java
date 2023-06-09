package gr.aueb.softeng.team02.model.view.Search.Information;

import java.util.ArrayList;

import gr.aueb.softeng.team02.view.Search.Information.InformationView;

public class InformationViewStub implements InformationView {

    ArrayList <String> prerequisites;
    String title;
    String prof;
    String desc;
    int ects;
    @Override
    public void showInfo(String title, String professor, int ects, int id, String descrip, ArrayList<String> prerequisites) {
        this.prerequisites= prerequisites;
        this.title=title;
        this.ects=ects;
        this.desc= descrip;
        this.prof=professor;

    }

    public int getPrereSize(){

        if(!(this.prerequisites==null)) {
            return prerequisites.size();
        }
        return 0 ;
    }

    public String getTitle() {
        return title;
    }

    public String getProf() {
        return prof;
    }

    public String getDesc() {
        return desc;
    }

    public int getEcts() {
        return ects;
    }
}
