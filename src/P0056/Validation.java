/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0056;

import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    static Scanner sc = new Scanner(System.in);

    public static int checkInt() {
        while (true) {
            try {
                int x = Integer.parseInt(sc.nextLine().trim());
                return x;
            } catch (NumberFormatException o) {
                System.out.print("Input error! please try again: ");
            }
        }
    }

    public static int Age() {
        while (true) {
            try {
                int x = Integer.parseInt(sc.nextLine().trim());
                if (x >= 18 && x <= 50) {
                    return x;
                }
            } catch (NumberFormatException o) {
                System.out.print("Input error! please try again: ");
            }
        }
    }

    public static boolean checkID(ArrayList<Worker> list, String code) {
        for (Worker s : list) {
            if (code.equalsIgnoreCase(s.getId())) {
                return false;
            }
        }
        return true;
    }

    public static float salaryCheck() {
        while (true) {
            try {
                float x = Float.parseFloat(sc.nextLine().trim());
                if (x >= 0) {
                    return x;
                }
            } catch (NumberFormatException o) {
                System.out.print("Input error! please try again: ");
            }
        }
    }

    public static String inputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not Empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
}
