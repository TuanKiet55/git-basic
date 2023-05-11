package P0067;

import java.util.ArrayList;

public class AnalyzeString {

    public static boolean checkSquare(int n) {
        if ((Math.sqrt(n) * Math.sqrt(n)) == n) {
            return true;
        }
        return false;
    }

    public static void getNumber(String s) {
        ArrayList<Integer> square = new ArrayList();
        ArrayList<Integer> odd = new ArrayList();
        ArrayList<Integer> even = new ArrayList();
        ArrayList<Integer> number = new ArrayList();
        String n = s.replaceAll("\\D+", ",");
        if (n.charAt(0) == ',') {
            n = n.substring(1);
        }
        if (n.charAt(n.length() - 1) == ',') {
            n = n.substring(n.length() - 1);
        }

        String[] listnumber = n.split(",");
        for (int i = 0; i < listnumber.length; i++) {
            int check = Integer.parseInt(listnumber[i]);
            number.add(check);
            if (check % 2 != 0) {
                odd.add(check);
            }
            if (check % 2 == 0) {
                even.add(check);
            }
            if (checkSquare(check)) {
                square.add(check);
            }
        }
        System.out.println("Perfect Square Numbers: " + square);
        System.out.println("Odd Numbers: " + odd);
        System.out.println("Even Number " + even);
        System.out.println("All Number " + number);
    }

    public static void getCharacter(String s) {
        String uppercase = s.replaceAll("\\W|[0-9]|[a-z]", "");
        String lowercase = s.replaceAll("\\W|[0-9]|[A-Z]", "");
        String special = s.replaceAll("\\w", "");
        String allCharacter = s.replaceAll("[0-9]", "");
        System.out.println("Uppercase Characters:" + uppercase);
        System.out.println("Lowercase Characters: " + lowercase);
        System.out.println("Special Characters: " + special);
        System.out.println("All Characters: " + allCharacter);
    }

}
