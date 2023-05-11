package P0052.GUI;

import P0052.DTO.East_Asia_Countries;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Manage_East_Asia_Countries {
    
    private final static Scanner sc = new Scanner(System.in);
    private static ArrayList <East_Asia_Countries> memory = new ArrayList<East_Asia_Countries>();
    
//    Hàm Menu in ra danh sách lựa chọn và trả về độ dài của menu.
    public static void menu(String [] menu){
        System.out.printf("%37s\n","MENU");
        System.out.println("==========================================================================");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i+1) + ". " + menu[i]);
        }
        System.out.println("==========================================================================");   
        System.out.print("Enter your choice: "); 
    }
//    Hàm Validate 
    public static int ValidateInt() {
        while (true) {
            try {
                int x = Integer.parseInt(sc.nextLine().trim());
                return x;
            } catch (NumberFormatException o) {
                System.out.print("Input error! please try again: ");
            }
        }
    }
    
    public static float ValidateFloat() {
        while (true) {
            try {
                float x = Float.parseFloat(sc.nextLine().trim());
                return x;
            } catch (NumberFormatException o) {
                System.out.print("Input error! please try again: ");
            }
        }
    }
    
    public static String ValidateString(){
        while(true){
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.out.println("Not Empty");
                System.out.print("Enter again: ");
            }
            else return result;
        }
    }
    
    private static ArrayList<East_Asia_Countries> getListCountryByName(String name){
        ArrayList<East_Asia_Countries> list = new ArrayList<>();
        for (East_Asia_Countries input : memory) 
            if(name.equalsIgnoreCase(input.getCountryName())) 
                list.add(input);
        return list;
    }
    
    public static boolean checkID(String code){
        for (East_Asia_Countries east_Asia_Countries : memory) {
            if(code.equalsIgnoreCase(east_Asia_Countries.getCountryCode())) return false;
        } 
        return true;
    }
    
    
    public static void addCountryInformation(){ 
        while(true){
        System.out.print("Enter code of country: ");
        String code = ValidateString();
        if(!checkID(code)){
            System.out.println("ID has exist student! Please enter again: ");
            continue;
        }
        System.out.print("Enter name of country: ");    
        String name = ValidateString();
        System.out.print("Enter total Area: ");
        float totalArea = ValidateFloat();
        System.out.print("Enter terrain of country: ");
        String terrain = ValidateString();
        
        memory.add(new East_Asia_Countries(code, name, totalArea, terrain));
        return ;
        }
    }
    
    public static void getRecentlyEnteredInformation(){
        for (East_Asia_Countries input: memory) {
            input.display();
        }
    } 
    
    public static void searchInformationByName(){
        System.out.print("Enter name of country: ");    
        String name = ValidateString();
        ArrayList<East_Asia_Countries> ls = getListCountryByName(name);
        if(ls.isEmpty()) System.out.println("Can't find information of country " + name);
        else{
            for (East_Asia_Countries input : ls) 
                input.display();
        } 
    }
    
    public static void sortInformationByAscendingOrder(){
        if(memory.isEmpty()) {
            System.err.println("List is empty");
            return;
        }
        Collections.sort(memory);
        for (East_Asia_Countries input : memory) 
            input.display();
    }   
    
}