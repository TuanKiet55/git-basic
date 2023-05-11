/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0084;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static String checkInput() {
        String pattern = "\\d+";
        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Not empty!!!");
                continue;
            }
            if (!input.matches(pattern)) {
                System.err.println("Only number!!!");
                continue;
            }
            return input;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter number 1:  ");
        String numOne = checkInput();
        System.out.println("Enter number 2:  ");
        String numTwo = checkInput();

        BigInteger bigNumOne = new BigInteger(numOne);
        BigInteger bigNumTwo = new BigInteger(numTwo);
        System.out.println(bigNumOne.multiply(bigNumTwo));
    }
}
