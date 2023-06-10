package gr.aueb.softeng.team02.view.Submission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.dao.SubmissionDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Circumscription;
import gr.aueb.softeng.team02.model.Grade;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.model.Subject;
import gr.aueb.softeng.team02.model.Submission;
import gr.aueb.softeng.team02.util.SystemDate;

public class SubmissionFragmentPresenter {
    private SubmissionFragmentView view;
    private final AcademicYearDAO years;
    private final OfferedSubjectDAO offeredSubjects;
    private final StudentDAO students;
    private final GradeDAO grades;
    private final SubmissionDAO submissions;
    private final SubjectDAO subjects;
    private String year;
    private int studentId;

    /**
     * Contructor that initializes the daos
     *
     * @param years           AcademicYearDAO
     * @param offeredSubjects OfferedSubjectDAO
     * @param students        StudentDAO
     * @param grades          GradeDAO
     * @param submissions     SubmissionDAO
     * @param subjects        SubjectDAO
     */
    public SubmissionFragmentPresenter(AcademicYearDAO years, OfferedSubjectDAO offeredSubjects, StudentDAO students, GradeDAO grades, SubmissionDAO submissions, SubjectDAO subjects) {
        this.students = students;
        this.years = years;
        this.offeredSubjects = offeredSubjects;
        this.grades = grades;
        this.submissions = submissions;
        this.subjects = subjects;
    }

    /**
     * Set student id
     *
     * @param id the student id
     */
    public void setStudentId(int id) {
        this.studentId = id;
    }

    /**
     * Set the view that will help the presenter call functions in the fragment
     *
     * @param view
     */
    public void setView(SubmissionFragmentView view) {
        this.view = view;
    }

    /**
     * Creates a collection that will present the subjects in the fragment
     *
     * @param student_id student id
     * @param year       selected year
     * @return a hash map with key the title of the subject and value the semester
     */
    public HashMap<String, Integer> getOfferedSubjects(int student_id, String year) {
        HashMap<String, Integer> list = new HashMap<>();

        int semester = students.findSemesterOfStudent(student_id);
        List<OfferedSubject> offeredSubs;
        if (semester % 2 == 0) {
            offeredSubs = offeredSubjects.findByModulo(0, year);
        } else {
            offeredSubs = offeredSubjects.findByModulo(1, year);
        }
        ArrayList<OfferedSubject> substractList = new ArrayList<>();
        for (OfferedSubject sub : offeredSubs) {
            for (Grade g : grades.findPassedSubjectsByStudent(student_id)) {
                if (sub.getSubject().equals(g.getSubject().getSubject())) {
                    substractList.add(sub);
                    break;
                }
            }
        }
        offeredSubs.removeAll(substractList);
        for (OfferedSubject sub : offeredSubs) {
            list.put(sub.getTitle(), sub.getSemester());
        }
        return list;
    }

    /**
     * Creates the form
     */
    //show the offered students based on the selected year .
    public void makeForm() {
        this.year = years.getCurrentAcadYear().getAc_year();
        view.setForm(getOfferedSubjects(this.studentId, year));
    }

    /**
     * Called when the submit button is clicked.
     * Check the submission form and prints suitable message in all cases
     */
    public void submitClicked() {
        ArrayList<String> titles = view.submit();
        AcademicYear academicYear = years.find(year);
        int semester = students.findSemesterOfStudent(this.studentId);

        if (titles.size() == 0) {
            view.showErrorMessage("Error", "Select at least one subject");
            return;
        }

        Circumscription c;

        try {
            c = academicYear.getCircumscription(semester);
        } catch (AcademicYearException e) {
            view.showErrorMessage("Error", "No circumscription for this semester, please wait until a secretary define a new one");
            return;
        }

        Submission sub = new Submission();
        sub.setSemester(students.findSemesterOfStudent(this.studentId));
        sub.setAcademicYear(years.find(this.year));
        sub.setStudent(students.findStudentById(this.studentId));

        for (String s : titles) {
            try {
                sub.addChosenSub(this.offeredSubjects.findByYearAndName(this.year, s));
            } catch (Exception e) {
                view.showErrorMessage("Error", "Surpassed the limit of ECTS for this semester");
                return;
            }
        }

        if (c.getStart().isAfter(SystemDate.now())) {
            view.showErrorMessage("Error", "The process of submission registration has not started yet !");
            return;
        }
        if (c.getEnd().isBefore(SystemDate.now())) {
            view.showErrorMessage("Error", "The process of submission registration has already come to an end !");
            return;
        }

        submissions.save(sub);
        view.showPassedMsg("Successfully stored");
        view.changeToHomeScreen();
    }

    /**
     * Checks if the selected subject can be chosen be the student.
     * Searching if it exists at least one prerequisite subject
     *
     * @param title the selected subject title
     */
    public void checkPrerequisites(String title) {
        Set<Subject> prerequisities = subjects.findSubject(title).getPrerequisities();

        if (prerequisities.size() == 0) {
            // No prerequisites, then can be selected freely
            view.setCheckBox(true);
            return;
        }
        Set<Grade> gradings = grades.findByStudent(studentId);

        for (Subject sub : prerequisities) {
            for (Grade grade : gradings) {
                if (grade.getSubject().getSubject().equals(sub)) {
                    view.setCheckBox(true);
                    return;
                }
            }
        }
        view.showErrorMessage("Error", "Cannot select this subject because you had not passed at least one prerequisite course");
        view.setCheckBox(false);
    }
}
