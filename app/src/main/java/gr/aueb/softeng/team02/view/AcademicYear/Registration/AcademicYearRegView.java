package gr.aueb.softeng.team02.view.AcademicYear.Registration;

import java.util.Date;
import java.util.Locale;

public interface AcademicYearRegView {
    public String getAcademicYear();
    public String getStartDate();
    public String getEndDate();
    public void messageSave();
    public void setVisibleFirstX();
    public void setVisibleSecondX();
    public void setVisibleThirdX();
    public void messageDIDNTSave();

}
