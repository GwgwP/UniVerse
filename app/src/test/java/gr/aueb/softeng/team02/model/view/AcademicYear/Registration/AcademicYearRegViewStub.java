package gr.aueb.softeng.team02.model.view.AcademicYear.Registration;

import java.time.LocalDate;

import gr.aueb.softeng.team02.view.AcademicYear.Registration.AcademicYearRegView;

public class AcademicYearRegViewStub implements AcademicYearRegView {

    private String ac_year, title, message;
    private String start_date, end_date;
    private int message_save, message_not_save, fx, sx, tx, alert_message;

    public String getAc_year() {
        return ac_year;
    }

    public void setAc_year(String ac_year) {
        this.ac_year = ac_year;
    }

    public String getTitle() {
        return title;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getMessage() {
        return message;
    }

//    public void setMessage(String message) {
//        this.message = message;
//    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getMessage_save() {
        return message_save;
    }

//    public void setMessage_save(int message_save) {
//        this.message_save = message_save;
//    }

    public int getMessage_not_save() {
        return message_not_save;
    }

//    public void setMessage_not_save(int message_not_save) {
//        this.message_not_save = message_not_save;
//    }

    public int getFx() {
        return fx;
    }

//    public void setFx(int fx) {
//        this.fx = fx;
//    }

    public int getSx() {
        return sx;
    }
//
//    public void setSx(int sx) {
//        this.sx = sx;
//    }

    public int getTx() {
        return tx;
    }

//    public void setTx(int tx) {
//        this.tx = tx;
//    }

    public int getAlert_message() {
        return alert_message;
    }

//    public void setAlert_message(int alert_message) {
//        this.alert_message = alert_message;
//    }



    @Override
    public String getAcademicYear() {
        return ac_year;
    }

    @Override
    public String getStartDate() {
        return start_date;
    }

    @Override
    public String getEndDate() {
        return end_date;
    }

    @Override
    public void messageDIDNTSave() {
        this.message_not_save++;
    }

    @Override
    public void messageSave() {
        this.message_save++;
    }

    @Override
    public void setVisibleFirstX() {
        this.fx ++;
    }

    @Override
    public void setVisibleSecondX() {
        this.sx++;
    }

    @Override
    public void setVisibleThirdX() {
        this.tx++;
    }

    @Override
    public void alertUser(String title, String message) {
        this.title = title;
        this.message = message;
        this.alert_message ++;
    }
}
