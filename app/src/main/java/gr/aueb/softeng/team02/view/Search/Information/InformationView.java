package gr.aueb.softeng.team02.view.Search.Information;


import java.util.ArrayList;

public interface InformationView {

    /**
     * Shows the information of a offered subject
     *
     * @param descrip   : the description of the offered subject
     * @param ects      : the ects of the offered subject
     * @param id        : the id of the offered subject
     * @param professor : the professor of the offered subject
     * @param title     : the title of the offered subject
     * @param prerequisites : the prerequisites of the offered subject
     **/
    void showInfo(String title, String professor, int ects, int id, String descrip, ArrayList<String> prerequisites);
}
