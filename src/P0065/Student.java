package P0065;

public class Student {
    
    private String name;
    private String clas;
    private float mark_Math;
    private float mark_Physical;
    private float mark_Chemistry;
    private char Type;

    public Student() {
    }

    public Student(String name, String clas, float mark_Math, float mark_Physical, float mark_Chemistry) {
        this.name = name;
        this.clas = clas;
        this.mark_Math = mark_Math;
        this.mark_Physical = mark_Physical;
        this.mark_Chemistry = mark_Chemistry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public float getMark_Math() {
        return mark_Math;
    }

    public void setMark_Math(float mark_Math) {
        this.mark_Math = mark_Math;
    }

    public float getMark_Physical() {
        return mark_Physical;
    }

    public void setMark_Physical(float mark_Physical) {
        this.mark_Physical = mark_Physical;
    }

    public float getMark_Chemistry() {
        return mark_Chemistry;
    }

    public void setMark_Chemistry(float mark_Chemistry) {
        this.mark_Chemistry = mark_Chemistry;
    }
    
    public float avg(){
        return (mark_Math+mark_Physical+mark_Chemistry) / 3;
    }
    
    public char getType(){
        float avg = avg();
        if(avg > 7.5) Type = 'A';
        else if(avg >= 6) Type = 'B';
        else if(avg >= 4) Type = 'C';
        else Type = 'D';
        return Type;
    }

    @Override
    public String toString() {
        String output = "Name: " + name +
                "\nClasses: " + clas +
                "\nAVG: " + Math.round(avg()*100.0)/100.0 +
                "\nType: " + getType() +"\n";
        return output;
    }
    
}
