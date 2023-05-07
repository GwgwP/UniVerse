import java.util.ArrayList;

public class Subject {
    
    private static int Sid = 0;
    private int id;
    private String professor;
    private int ECTS;
    private String desc;
    private String title;
    // This List contains all the subjects that a student must pass in order to 
    private ArrayList<Subject> prerequisities = new ArrayList<>();

    public Subject() {
        this.id = Sid++;
    }
    
    public ArrayList<Subject> getPrerequisities() {
        return this.prerequisities;
    }

    public void addPrerequisities(Subject sub) {
        this.prerequisities.add(sub);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfessor() {
        return this.professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getECTS() {
        return this.ECTS;
    }

    public void setECTS(int eCTS) {
        this.ECTS = eCTS;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String toString() {
        return "\n" +
        "Title: " + this.title + "\n"
        "Professor: " + this.professor + "\n"
        "ECTS: " + this.ECTS + "\n"
        "Description: " + this.desc + "\n"

    }
}
