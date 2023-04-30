import java.sql.Date;

public class Circuscription {
    
    private static int Cid = 0;
    private String ac_year;
    private int id;
    private int ECTS;
    private Date start;
    private Date end;
    private int semester;

    public Circuscription(int eCTS, Date start, Date end, int semester, String year) {
        this.id = Cid++;
        ECTS = eCTS;
        this.start = start;
        this.end = end;
        this.semester = semester;
        this.ac_year = year;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getECTS() {
        return ECTS;
    }
    public void setECTS(int eCTS) {
        ECTS = eCTS;
    }
    public Date getStart() {
        return start;
    }
    public void setStart(Date start) {
        this.start = start;
    }
    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }
    public int getSemester() {
        return semester;
    }
    public void setSemester(int semester) {
        this.semester = semester;
    } 










}