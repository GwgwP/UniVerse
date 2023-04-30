import java.util.ArrayList;

public class OfSubjects_Grades {
   
    private int student_id;
    private int subject_id;
    private double grade;

    private static ArrayList<OfSubjects_Grades> grades = new ArrayList<>();
 
    public OfSubjects_Grades(int st, int sub, double grade ){
        this.student_id = st;
        this.subject_id = sub;
        this.grade = grade;    
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

        
}
