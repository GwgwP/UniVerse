package gr.aueb.softeng.team02;

import java.util.ArrayList;
import java.util.List;

public class GradeProviderStub implements StudentBook {
    private List<Submission> submissionList = new ArrayList<>();
    @Override
    public void sendGrades(Grade grade, int studentId, Subject subject, AcademicYear year) {
        for (Submission sub : this.submissionList) {
            if (sub.getAcademicYear().equals(year) && sub.getStudent().getId() == studentId) {
                for (OfferedSubject subj : sub.getChosenSub()) {
                    if (subj.getSubject().equals(subject)) {
                        subj.setGrade(grade);
                    }
                }
            }
        }
    }
}
