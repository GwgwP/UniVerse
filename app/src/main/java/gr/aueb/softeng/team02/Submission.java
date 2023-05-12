package gr.aueb.softeng.team02;

import java.util.*;

public class Submission {
    private int semester;
    private Set<OfferedSubject> chosenSub;

    public Submission(int semester) {
        this.semester = semester;
        this.chosenSub = new HashSet<OfferedSubject>();
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

    public void setChosenSub(OfferedSubject sub) throws Exception {
        // If one subject is chosen, then it cannot be selected again. Implement it with UI
        if (this.chosenSub.contains(sub)) {
            throw new Exception();
        }
        this.chosenSub.add(sub);
    }

    private int calculateECTS() {
        int sum = 0;
        for (OfferedSubject sub : this.chosenSub) {
            sum += sub.getEcts();
        }
        return sum;
    }

    // TODO Controller will check if the submission is valid, by accessing the daos
}
