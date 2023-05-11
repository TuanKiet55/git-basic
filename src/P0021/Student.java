package P0021;

import java.util.ArrayList;
import java.util.Scanner;

public class Student implements Comparable<Student>{

    private String ID;
    private String Name;
    private String Semester;
    private String Course;

    public Student() {
    }

    public Student(String ID, String Name, String Semester, String Course) {
        this.ID = ID;
        this.Name = Name;
        this.Semester = Semester;
        this.Course = Course;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }

    public void output(){
        System.out.printf("%-20s%-10s%-10s\n", Name, Semester, Course);
    }

    @Override
    public int compareTo(Student o) {
        return o.Name.compareTo(this.Name);
    }

    
}
