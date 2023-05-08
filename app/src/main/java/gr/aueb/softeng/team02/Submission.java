// package gr.aueb.softeng.team02;
import java.util.*;
public class Submission {

    private static int Gid = 0;
    private int id;
    private int semester;
    private Set<OfferedSubject> chosenSub;
    // What we are going to do with the academic year

    public Submission(int semester, String ac_year) {
        this.id = Submission.Gid++;
        this.semester = semester;
        this.chosenSub = new HashSet<OfferedSubject>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Set<OfferedSubject> getChosenSubjects() {
        // TODO Checks needed if null
        return chosenSub;
    }
    public boolean checkChosenSub(OfferedSubject sub) {
        // TODO Check if there is a duplicate
        for (OfferedSubject subject : this.chosenSub) {
            if (subject.getSubjectId() == sub.getSubjectId()) {
                return false;
            }
        }
        return true;
    }
    public void addChosenSub(OfferedSubject sub) {
        if (this.checkChosenSub(sub)) {
            this.chosenSub.add(sub);
        }
        // TODO Check to sent error or message
    }

    public int getTotalEcts() {
        int totalEcts = 0;
        for (OfferedSubject subject : this.chosenSub) {
            totalEcts += subject.getEcts();
        }
        return totalEcts;
    }
}
