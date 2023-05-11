package P0011;

import java.util.Scanner;

public class LinearSearch {

    public static void createRandom(int a[], int n) {
        for (int i = 0; i < n; i++) {
            double randomDouble = Math.random();
            randomDouble = randomDouble * 100 + 1;
            int randomInt = (int) randomDouble;
            a[i] = randomInt;
        }
    }

    public static void Search(int a[], int x) {
        int check = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                System.out.println("Found " + x + " at index: " + i);
                check++;
            }else{
                check = check;
            }
        }
        if(check == 0){
            System.out.println(x + " not in the array!");
        }
    }

    public static int validate() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int x = Integer.parseInt(sc.nextLine());
                if (x > 0) {
                    return x;
                }
            } catch (NumberFormatException o) {
                System.out.print("Input error! please try again: ");
            }
        }
    }

    public static void display(int a[]) {
        System.out.print("The array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        System.out.print("Enter number of array'elements: ");
        int n = validate();
        int a[] = new int[n];
        createRandom(a, n);
        System.out.print("Enter search value: ");
        int x = validate();
        display(a);
        Search(a, x);
    }

}
