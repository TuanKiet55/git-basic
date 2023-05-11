/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0055;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Manager {

    private ArrayList<Doctor> list = new ArrayList<>();

    public void addDoctors() {
        while (true) {
            System.out.println("-----Add Doctor-----");
            System.out.println("Enter Code: ");
            String id = Validation.inputSring();
            if (checkID(id) == false) {
                System.out.println("Already exists enter another id");  
                continue;
            }
            System.out.println("Enter Name:  ");
            String name = Validation.inputSring();
            System.out.println("Enter Specialization: ");
            String Specialization = Validation.inputSring();
            System.out.println("Enter Availability :");
            int availability = Validation.inputInt();
            list.add(new Doctor(id, name, Specialization, availability));
            System.out.println("Create doctor success: ");
            return;
        }
    }

    public boolean checkID(String id) {
        for (Doctor doctor : list) 
            if (doctor.getCode().equalsIgnoreCase(id))
                return false;
        return true;
    }
    public void updeatDoctors(){
        System.out.println("Enter Code Doctor you want updeat: ");
        String n = Validation.inputSring();
        for (Doctor doctor : list) {
            if(doctor.getCode().equalsIgnoreCase(n)){
                list.remove(doctor);
                addDoctors();
                System.out.println(" Updeat Success.");
                return;
            }    
        }
        System.out.println("Doctor code does not exist: ");
        
    }
    public void deleteDoctors(){
        System.out.println("Enter doctor you want delete: ");
        String n = Validation.inputSring();
        for (Doctor doctor : list) {
            if(doctor.getCode().equalsIgnoreCase(n)){
                list.remove(doctor);
                System.out.println("Delete Success: ");
            }
            
        }
    }
    public void display(){
        if(list.isEmpty()){
            System.out.println("Not empty");
            return;
        }
        System.out.println("Doctor Information");   
        System.out.printf("%-5s%-15s%-15s%-5s\n" , "Code", "Name", "Specialization", "Availability");
        for (Doctor doctor : list) {
            doctor.output();
            
        }
    } 
    public void searchDoctor(){
        if(list.isEmpty()){
            System.out.println("Not empty");
            return;
        }
            System.out.println("Enter Code Doctor you want rearch: ");
            String n = Validation.inputSring();
            for (Doctor doctor : list) {
                if(doctor.getCode().equalsIgnoreCase(n))
                    display();
                
            }
    
    }
    
    public void readFile(String path) throws FileNotFoundException, IOException{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String doctor = "";
            while (    (doctor = br.readLine())   != null){
//                System.out.println(doctor);
                String [] dt = doctor.split("\\|");
                if(checkID(dt[0])) 
                       list.add(new Doctor(dt[0].trim(), dt[1].trim(), dt[2].trim(), Integer.parseInt(dt[3].trim())));
            } 
                br.close();
                fr.close();
                System.out.println("Success");
    }
    
    public void saveFormFile(String path) throws IOException{
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        for(Doctor doctor : list){
            bw.write(doctor.getCode()+ "|"+ doctor.getName()+ "|" + 
                    doctor.getSpecialization()+ "|" + doctor.getAvailability());
            bw.newLine();
        }
        bw.close();
        fw.close();
        System.out.println("Success");
       
    }
    
    
    
    
    }  
       
        
                
        
    
       

