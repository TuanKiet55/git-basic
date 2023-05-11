package P0021;

import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    private final static Scanner sc = new Scanner(System.in);
    
    public static double inputDouble() {
        while (true) {
            try {
                double x = Double.parseDouble(sc.nextLine().trim());
//                if (x > 0) {
//                    return x;
//                }
                return x;
            } catch (NumberFormatException o) {
                System.out.print("Input error! please try again: ");
            }
        }
    }
    public static int inputInt() {
        while (true) {
            try {
                int x = Integer.parseInt(sc.nextLine().trim());
//                if (x > 0) {
//                    return x;
//                }
                return x;
            } catch (NumberFormatException o) {
                System.out.print("Input error! please try again: ");
            }
        }
    }
    public static String inputString(){
        while(true){
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.out.println("Not Empty");
                System.out.print("Enter again: ");
            }
            else return result;
        }
    }
// check user yes or no
    public static boolean checkYN(){
        while(true){
            String result = inputString();
            if(result.equalsIgnoreCase("Y"))return true;
            if(result.equalsIgnoreCase("N")) return false;
            System.err.println("Please enter y/Y or n/N");
            System.out.print("Enter again: ");
        }
    }
// check user Update or Delete
    public static boolean checkUD(){
        while(true){
            String result = inputString();
            if(result.equalsIgnoreCase("U")) return true;
            if(result.equalsIgnoreCase("D")) return false;
            System.err.println("Please enter U/u or d/D");
            System.out.print("Enter again: ");
        }
    }
// Check chẵn, lẻ, chính phương của Lab50
    public static boolean checkOdd(double x) {
        return x % 2 == 1;
    }
    public static boolean checkEven(double x) {
        return x % 2 == 0;
    }
    public static boolean checkSquare(double x){
        int y = (int) Math.sqrt(x);
        return y*y == x;
    }
    public static String all(double[]a){
        String stringOdd = "Number is Odd:";
        String stringEven = "Number is Even:";
        String stringSquare = "Number is Perfect Square:";
        for(int i=0; i<a.length; i++)
            {
                if(checkOdd(a[i])) stringOdd += a[i] + ", ";
                else if(checkEven(a[i])) stringEven += a[i] + ", ";
                if(checkSquare(a[i])) stringSquare += a[i] + ", ";
            }
        return stringOdd + "\n" + stringEven + "\n" + stringSquare;
    }
}
