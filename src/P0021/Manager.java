package P0021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Manager {
    
    private ArrayList<Student>  list = new ArrayList<>();
// Create new student (function 1)
    public void createStudent(){
        // if number of student greater than 3 ask user continue or not
        if(list.size() > 4){
            System.err.print("Do you want to continue (Y/N): ");
            if(!Validation.checkYN()) return;
        }
        while(true){
            System.out.print("Enter ID: ");
            String id = Validation.inputString();
            System.out.print("Enter Name: ");
            String name = Validation.inputString();
            // check id, name
            if(!checkIDexist(id, name)){
                System.err.println("ID has exist student. Please enter again: ");
                continue;
            }
            System.out.print("Enter semester: ");
            String semester = inputSemeter();
            System.out.print("Enter Course: ");
            String course = inputCourse();
            // check all info of student
            if(checkStudentexist(id, semester, course)){
                list.add(new Student(id, name, semester, course));
                System.err.println("Create student success.");
                return;
            }
            System.err.println(name + " are studied course " + course + " semester " + semester);
        }
    }
    // check ID exist
    public boolean checkIDexist(String id, String name){
        for (Student student : list) 
            if(id.equalsIgnoreCase(student.getID()) && 
                    !name.equalsIgnoreCase(student.getName())) return false;
        return true;
    }
// check student exist
    public boolean checkStudentexist(String id, String seme, String course){
        for (Student student : list) 
            if(id.equalsIgnoreCase(student.getID())&&
                    seme.equalsIgnoreCase(student.getSemester()) &&
                    course.equalsIgnoreCase(student.getCourse()))
                return false;
        return true;
    }
    // input course
    public static String inputCourse(){
        while(true){
            String course = Validation.inputString();
            if(course.equalsIgnoreCase("Java")
                    || course.equalsIgnoreCase(".net")
                    || course.equalsIgnoreCase("c/c++"))
                return course;
            System.err.println("Only 1 of 3 courses exist: Java, .net, C/C++");
            System.out.print("Please Re-Enter: ");
        }
    }  
// input semeter
    public static String inputSemeter(){
        while(true){
            String semeter = Validation.inputString();
            if(semeter.equalsIgnoreCase("Spring")
                    || semeter.equalsIgnoreCase("Summer")
                    || semeter.equalsIgnoreCase("Fall")
                    || semeter.equalsIgnoreCase("Winter"))
                return semeter;
            System.err.println("The course only has 4 seasons: Spring, Summer, Fall, Winter");
            System.out.print("Please Re-enter: ");
        }
    }
// Find
    public ArrayList<Student> listStudent_Name(){
        ArrayList<Student> list_name = new ArrayList<>();
        System.out.print("Enter name to find: ");
        String name = Validation.inputString();
        System.out.println("");
        for (Student student : list) 
            if(student.getName().contains(name))
                list_name.add(student);
        return list_name;
    }
// sort (function 2)
    public void findAndsort(){
        if(list.isEmpty()){
            System.err.println("List is empty. ");
            return;
        }
        ArrayList<Student> List_name = listStudent_Name();
        if(List_name.isEmpty())
            System.err.println("Not exist.");
        else{
            Collections.sort(List_name);
            System.out.printf("%-20s%-10s%-10s\n", "Student name", "Semester", "Course");
            for (Student student : List_name) 
                student.output();
        }
    }
// update or delete student (function3)
    public void updateOrDelete(){
        if(list.isEmpty()){
            System.err.println("List is empty");
            return;
        }
        System.out.print("Enter Id: ");
        String id = Validation.inputString();
        ArrayList<Student> ls = listbyId(id);       
        if(ls.isEmpty()){
            System.err.println("Not found student.");
            return;
        }
        Student student = getStudentUD(ls);
        System.out.print("Do you want to update (U) or delete (D) student: ");
        if(Validation.checkUD()){
            while(true){
            System.out.print("Enter id: ");
            String idStudent = Validation.inputString();
            System.out.print("Enter name student: ");
            String name = Validation.inputString();
            System.out.print("Enter semester: ");
            String semester = inputSemeter();
            System.out.print("Enter name course: ");
            String course = inputCourse();
            if (checkIDexist(idStudent, name) &&
                    checkStudentexist(idStudent, semester, course)) {
                    student.setID(idStudent);
                    student.setName(name);
                    student.setSemester(semester);
                    student.setCourse(course);
                    System.err.println("Update success.");
                    return;
            }
            else 
                System.err.println(name + " are studied course " + course + " semester " + semester);
            }
        }else{
            list.remove(student);
            System.err.println("Delete success.");
        }
    }
// find list student has ID = input
    public ArrayList<Student> listbyId(String id){
        ArrayList<Student> ls = new ArrayList<>();
        for (Student l : list) 
            if(l.getID().equalsIgnoreCase(id))
                ls.add(l);
        return ls;
    }
// choice student to Update or Delete
    public Student getStudentUD(ArrayList<Student> ls){
        for (int i =0; i< ls.size(); i++) {
            System.out.print((i+1) + ".\t");
            ls.get(i).output();
        }
        int choice;
        do{
            System.out.print("Enter the number you want to edit: ");
            choice = Validation.inputInt();
        }while(choice<=0 || choice >ls.size());
        return ls.get(choice-1);
    }
// report (function 4)
    public void report(){
        if(list.isEmpty()){
            System.err.println("List is empty");
            return;
        }
        ArrayList<Student> ls = new ArrayList<>();
        ls = (ArrayList<Student>)list.clone();
        int i = 0;
        while(i < ls.size()){
            int total = 1;
            String id = ls.get(i).getID();
            String course = ls.get(i).getCourse();
            for(int j =i+1; j<ls.size();)
                if(id.equalsIgnoreCase(ls.get(j).getID()) &&
                        course.equalsIgnoreCase(ls.get(j).getCourse())){
                    total ++;
                    ls.remove(j);
                }else j++;
            System.out.printf("%-7s | %-20s | %-10s | %-10s\n",ls.get(i).getID(),ls.get(i).getName(),ls.get(i).getCourse(),total);
            i++;
        }
    }
    public boolean ReadFile(String path){
        Scanner sc = new Scanner(System.in);
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            System.out.println("Please enter the input file information in the following format");
            String student = "";
            System.out.println("Id|Name|Semester|Course");
            System.out.println("Are you sure the file is in the correct format?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("your selection.. ");
            int n = Validation.inputInt();
            if(n != 1) return false; 
            while((student = br.readLine()) != null){
                String[] std = student.split("\\|");
                if(checkIDexist(std[0], std[1]) &&
                        checkStudentexist(std[0], std[2], std[3]))
                    list.add(new Student(std[0], std[1], std[2], std[3]));
            }
            br.close();
            fr.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
// read file (function 5)
    public void check_readFile(){
        boolean kq = ReadFile("lib.txt");
        if (kq == true) 
            System.err.println("Read File Successfully");
        else 
            System.err.println("Read Save Failed");
    }
    public boolean WriteFile(String path) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Do you want to overwrite or save new?");
            System.out.println("1. Overwrite");
            System.out.println("2. Save new");
            System.out.print("your selection.. ");
            int choice = Validation.inputInt();
            FileWriter fw;
            if(choice == 1) fw = new FileWriter(path, true);
            else fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            //bw.newLine();
            for (Student t : list) {
                String line = t.getID()+"|"+t.getName()+"|"+t.getSemester()+"|"+t.getCourse();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
// save file (function 6)
    public void check_writeFile(){
        boolean result = WriteFile("lib.txt");
        if(result)
            System.err.println("Write File Successfully");
        else 
            System.err.println("Write File Failed");
    }
}
