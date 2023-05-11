package P0067;

import static P0067.AnalyzeString.getCharacter;
import static P0067.AnalyzeString.getNumber;
import java.util.Scanner;

public class MyMain {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===== Analysis String program =====");
        System.out.print("Input String: ");
        String s = sc.nextLine();
        System.out.println("-----------------------------------");
        if (s.isEmpty()) {
            System.out.println("String is empty!!");
        } else {
            getNumber(s);
            getCharacter(s);
        }
    } 
}
