package Assigment_1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lab8 {

    public static void countCharacter(String a) {
        StringTokenizer st = new StringTokenizer(a);
        ArrayList<String> n = new ArrayList<>();
        while (st.hasMoreTokens()) {
            n.add(st.nextToken());
        }
        ArrayList alreadyCounted = new ArrayList<String>();
        for (int i = 0; i < n.size(); i++) {
            int count = 1;
            if (!alreadyCounted.contains(n.get(i))) {
                for (int j = i + 1; j < n.size(); j++) {
                    if (n.get(i).equals(n.get(j))) {
                        count++;
                    }
                }
                System.out.print(n.get(i) + "=" + count + ",");
                alreadyCounted.add(n.get(i));
            }
        }
        System.out.println("");
    }
    public static void countLetter(String a){
        a = a.replace("", " ");
        StringTokenizer st = new StringTokenizer(a);
        ArrayList<String> n = new ArrayList<>();
        while (st.hasMoreTokens()) {
            n.add(st.nextToken());
        }
        ArrayList alreadyCounted = new ArrayList<String>();
        for (int i = 0; i < n.size(); i++) {
            int count = 1;
            if (!alreadyCounted.contains(n.get(i))) {
                for (int j = i + 1; j < n.size(); j++) {
                    if (n.get(i).equals(n.get(j))) {
                        count++;
                    }
                }
                System.out.print(n.get(i) + "=" + count + ", ");
                alreadyCounted.add(n.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = new String();
        System.out.print("Enter your content: ");
        a = sc.nextLine();
        countCharacter(a);
        countLetter(a);
    }

}
