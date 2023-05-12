package gr.aueb.softeng.team02;

import java.util.*;

public class AcademicYear {
    private String ac_year;
    // lydia
    private Map<Integer, Circumscription> circList;
    private Map<Integer, OfferedSubject> offeredSubjectList;

    public AcademicYear(String ac_year) {
        this.ac_year = ac_year;
        this.circList = new HashMap<Integer, Circumscription>();
    }

    public void setAc_year(String ac_year) {
        this.ac_year = ac_year;
    }

    public String getAc_year() {
        return ac_year;
    }

    public void addOfferedSubject(OfferedSubject offeredSubject) throws Exception {
        if (this.offeredSubjectList.get(offeredSubject.getSubjectId()) != null) {
            throw new Exception();
        }
        this.offeredSubjectList.put(offeredSubject.getSubjectId(), offeredSubject);
    }

    public Set<OfferedSubject> getAllOfferedSubjects(int semester) {
        // Return all offered subjects of a given semester in order to present them in the execution of the submission
        Set<OfferedSubject> offeredSubjects = new HashSet<>();
        for (Map.Entry<Integer, OfferedSubject> subject : this.offeredSubjectList.entrySet()) {
            if (subject.getValue().getSemester() == semester) {
                offeredSubjects.add(subject.getValue());
            }
        }
        return offeredSubjects;
    }

    public OfferedSubject getOfferedSubject(int id) throws Exception {
        if (this.offeredSubjectList.get(id) == null) {
            throw new Exception();
        }
        return this.offeredSubjectList.get(id);
    }

    public void addCircumscription(Circumscription c) throws IllegalAccessException {
        // TODO throw exception if there is a previous circumscription in the semester
        if (this.circList.get(c.getSemester()) != null) {
            throw new IllegalAccessException();
        }
        this.circList.put(c.getSemester(), c);
    }

    /**
     * get the circumscription depending on the semester.
     */
    public Circumscription getCircumscription(int semester) throws IllegalAccessException {
        // TODO Throw exception if there is no circumscription on the specific semester
        // Only one circumscription per semester
        if (this.circList.get(semester) == null) {
            throw new IllegalAccessException();
        } else {
            return this.circList.get(semester);
        }
    }

    public void removeOffSubjectBySemester(int semester) {
        // Function for step 4
        for (Map.Entry<Integer, OfferedSubject> entry : this.offeredSubjectList.entrySet()) {
            if (entry.getValue().getSemester() == semester) {
                this.offeredSubjectList.remove(entry.getValue());
            }
        }
    }

    public void removeOffSubjectById(int id) {
        // Function for step 8
        if (this.offeredSubjectList.get(id) != null) {
            this.offeredSubjectList.remove(id);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof AcademicYear)) {
            return false;
        }
        //TODO: Check if there are other parameters to check the equality between two objects
        AcademicYear year = (AcademicYear) other;
        return (this.ac_year.equals(year.ac_year));
    }
}
