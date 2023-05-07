package gr.aueb.softeng.team02.model;

public class Student  extends User{

    private int semester;
    private int am;
    private ArrayList<Subject> subjects = new ArrayList<>();



    public Student(String username , String password , String name , String surname, int semester, int am){
        this.id = id++;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.semester = semester;
        this.am = am;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
    public void addSub(Subject sub){
        this.subjects.add(sub);
            
    }

    public int getSemester() {
        return semester;
    }


    public void setSemester(int semester) {
        this.semester = semester;
    }


    public int getAm() {
        return am;
    }


    public void setAm(int am) {
        this.am = am;
    }



    
    
}
