package P0065;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
 
public class Manager {
    
    private final ArrayList<Student> list = new ArrayList<>();
// Create new student (Function 1)
    public void InputStudent(){
        while(true){
            System.err.println("Enter information Student");
            System.out.print("Name: ");
            String name = Validation.inputString();
            String clas;
            do{
                System.out.print("Class: ");
                clas = Validation.inputString();
                if(!checkClass(clas)) System.err.println("Class does not exist. Please Enter again:");
            }while(!checkClass(clas));
            clas = clas.toUpperCase();
            System.out.print("Math: ");
            float math = Validation.inputMark();
            System.out.print("Physical: ");
            float physical = Validation.inputMark();
            System.out.print("Chemistry: ");
            float chemistry = Validation.inputMark();
            list.add(new Student(name, clas, math, physical, chemistry));
            System.out.println("Successfully entered");
            System.err.println("Do you want to enter more student information?(Y/N): ");
            if(!Validation.checkYN()) return;
        }
    }
// Check Class SE or SA
    public boolean checkClass(String clas){
        if(clas.matches("['S'\\'s'\\'I'\\'i']"
                + "['E'\\'B'\\'e'\\'b']\\d{2}[a-zA-Z]\\d{2}")) return true;
        return false;
    }
// Display
    public void display(){
        int a=0,b=0,c=0,d=0;
        for(int i=0; i< list.size(); i++){
            System.out.println("-----Student " + (i+1) + " -----");
            System.out.println(list.get(i));
            switch(list.get(i).getType()){
                case 'A': a++; break;
                case 'B': b++; break;
                case 'C': c++; break;
                case 'D': d++; break;
            }
        }
        System.out.println("--------Classification Info -----");
        System.out.printf("A: %.1f%%", (float)a/list.size()*100);
        System.out.printf("\nB: %.1f%%", (float)b/list.size()*100);
        System.out.printf("\nC: %.1f%%", (float)c/list.size()*100);
        System.out.printf("\nD: %.1f%%\n", (float)d/list.size()*100);
    }
    public boolean checkMark(float mark){
        return mark >=0 && mark <=10;
    }
    public void ReadFile(String path){
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
            if(n != 1) {System.err.println("Read Save Failed"); return;}
            while((student = br.readLine()) != null){
                String[] std = student.split("\\|");
                float math = Float.parseFloat(std[2]);
                float physical = Float.parseFloat(std[3]);
                float chemistry = Float.parseFloat(std[4]);
                if(checkClass(std[1]) && checkMark(math) 
                        && checkMark(physical)
                        && checkMark(chemistry))
                    list.add(new Student(std[0], std[1], math, physical, chemistry));
            }
            br.close();
            fr.close();
            System.err.println("Read File Successfully");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("Read Save Failed");
    }
    public void WriteFile(String path) {
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
                String line = t.getName()+"|"+t.getClas()+"|"+t.getMark_Math()+
                        "|"+t.getMark_Physical()+'|'+t.getMark_Chemistry();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.err.println("Write File Successfully");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("Write File Failed");
    }
}
