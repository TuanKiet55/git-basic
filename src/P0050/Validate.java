package P0050;

import java.util.Scanner;

public class Validate {

    public static double input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                double x = Double.parseDouble(sc.nextLine());
//                if (x > 0) {
//                    return x;
//                }
                return x;
            } catch (NumberFormatException o) {
                System.out.print("Input error! please try again: ");
            }
        }
    }

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
    public static void main(String[] args) {
        System.out.println(checkSquare(4));
    }
}
