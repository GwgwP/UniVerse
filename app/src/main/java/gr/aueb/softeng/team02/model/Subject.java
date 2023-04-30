import java.util.ArrayList;

public class Subject {
    
    private static int Sid = 0;
    private int id;
    private String professor;
    private int ECTS;
    private String desc;
    private String title;
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
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int eCTS) {
        ECTS = eCTS;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
