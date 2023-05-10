package gr.aueb.softeng.team02;

import java.util.*;

public class Submission {

    private static int gid = 0;
    private int id;
    private int semester;



    private Set<OfferedSubject> chosenSub;

    // What we are going to do with the academic year
    private AcademicYear ac_year;


    public Submission(int semester, AcademicYear ac_year) {
        this.id = Submission.gid++;
        this.ac_year = ac_year;
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

    public Set<OfferedSubject> getChosenSub() {
        return chosenSub;
    }

    public void setChosenSub(Set<OfferedSubject> chosenSub) {
        this.chosenSub = chosenSub;
    }

    public Set<OfferedSubject> getChosenSubjects() {
        // TODO Checks needed if null
        return chosenSub;
    }

    private boolean checkECTS() {
        // TODO Check if there is a duplicate
        Circumscription c = ac_year.getCircumscription(semester);
        int sum = 0;
        for (OfferedSubject sub : chosenSub) {
            sum += sub.getEcts();
        }
//        if(sum > c.getEcts())
//        {
//            return false;
//        }
//        return true;
        return sum <= c.getEcts();

//        for (OfferedSubject subject : this.chosenSub) {
//            if (subject.getSubjectId() == sub.getSubjectId()) {
//                return false;
//            }
//        }
    }
    private boolean checkPrerequisites()
    {
        return true;
    }

    public boolean checkSubmission()
    {
        return (checkECTS() && checkPrerequisites());
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
