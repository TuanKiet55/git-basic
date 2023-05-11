package Assigment_1;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import Assigment_1.Lab1;
import Assigment_1.Lab4;
import Assigment_1.Lab6;

public class MyMain {

    public static int[] input(int[] arr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of array:");
        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(1, n + 1);
        }
        return arr;
    }

    public static String output(int[] arr) {
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i] + " ";
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Choose;
        int[] arr = {};
        int value;
        do {
            System.out.println("\n-----------MENU-----------\n");
            System.out.println("1. Lab 1 bubble sort");
            System.out.println("2. Lab 4 quick sort");
            System.out.println("3. Lab 6 binary search");
            System.out.println("Others choose: Exit");
            System.out.print("\nEnter your choose: ");
            Choose = sc.nextInt();
            switch (Choose) {
                case 1:
                    arr = input(arr);
                    System.out.println("Unsorted array:\n" + output(arr));
                    Lab1.bubbleSort(arr);
                    System.out.println("Sorted array:\n" + output(arr));
                    break;
                case 2:
                    arr = input(arr);
                    System.out.println("Unsorted array:\n" + output(arr));
                    Lab4.quickSort(arr, 0, arr.length - 1);
                    System.out.println("Sorted array:\n" + output(arr));
                    break;
                case 3:
                    arr = input(arr);
                    System.out.println("Enter search value: ");
                    value = sc.nextInt();
                    while (value > arr.length || value < 1) {
                        System.out.println("Reenter search value [1.. " + arr.length + "]");
                        value = sc.nextInt();
                    }
                    Lab4.quickSort(arr, 0, arr.length - 1);
                    System.out.println("Sorted array:\n" + output(arr));
                    System.out.println("Found " + value+" at index: "
                            +Lab6.binarySearch(arr, value, 0, arr.length - 1));
                    break;
                default:
                    System.out.println("Thanks...");
                    break;
            }
        } while (1 <= Choose && Choose <= 3);

    }
}
