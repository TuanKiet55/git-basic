/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0055;

import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {

    private final static Scanner sc = new Scanner(in);

    //check user input double
    public static double inputDouble() {
        while (true) {
            try {
                double x = Double.parseDouble(sc.nextLine().trim());
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Input error! Plese try again.");
            }

        }
    }

    //check user input int
    public static int inputInt() {
        while (true) {
            try {
                int x = Integer.parseInt(sc.nextLine().trim());
//                if(x > 0) return x;
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Input error! Plese try again.");
            }

        }
    }

    //check user input string
    public static String inputSring() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty.");
                System.out.println("Enter again.");
            } else {
                return result;
            }
        }
    }

    //check user input number limit
//    public static int checkInputIntLimit(int min, int max) {
//        while (true) {
//            try {
//                int result = Integer.parseInt(sc.nextLine().trim());
//                if (result < min || result > max) {
//                    throw new NumberFormatException();
//                }
//                return result;
//            } catch (NumberFormatException e) {
//                System.out.println("Plese input number in rage" + min +"," + max );
//                System.out.println("Enter again: ");
//            }
//        }
//
//    }
    //check code exist or not
//    public static boolean checkCodeExist(ArrayList<Doctor> Id, String code ){
//        //check from first to last list
//        for(Doctor doctor : Id){
//            if(code.equalsIgnoreCase(doctor.getCode())){
//                return false;
//            }
//        }
//        return true;
//    }
 
    
   
    
    
    
    
    
    
    
    

}
