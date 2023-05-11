package P0056;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Worker {

    static ArrayList<Worker> list = new ArrayList();
    static Scanner sc = new Scanner(System.in);

    public static void addWorker() {
        System.out.println("------- Add Worker -------");
        while (true) {
            System.out.print("Enter Id: ");
            String id = Validation.inputString();
            if (!Validation.checkID(list, id)) {
                System.out.println("ID has exist! Please enter again: ");
                continue;
            }
            System.out.print("Enter name: ");
            String name = Validation.inputString();
            System.out.print("Enter Age: ");
            int age = Validation.Age();
            System.out.print("Enter Salary: ");
            float sala = (float) Validation.salaryCheck();
            System.out.print("Enter Work location: ");
            String wolo = Validation.inputString();
            list.add(new Worker(id, name, age, sala, wolo));
            return;
        }
    }

    public static void upSalary() {
        if (list.isEmpty()) {
            System.out.println("There is no worker at all!");
        }
        System.out.println("------- Up Salary -------");
        while (true) {
            System.out.print("Enter Id: ");
            String id = Validation.inputString();
            if (Validation.checkID(list, id)) {
                System.out.println("ID hasn't exist! Please enter again: ");
                continue;
            }
            for (Worker input : list) {
                System.out.printf("%-17s %-20s %-20s %-20s %-20s\n", "ID", "Name", "Age", "Salary", "Work location");
                if (id.equalsIgnoreCase(input.getId())) {
                    input.display();
                    System.out.println("");
                    System.out.print("Enter values: ");
                    float psala = Validation.salaryCheck();
                    float x = input.getSalary() + psala;
                    input.setSalary(x);
                    System.out.println("Done");
                    input.display();
                }
            }
            return ;
        }
    }

    public static void downSalary() {
        if (list.isEmpty()) {
            System.out.println("There is no worker at all!");
        }
        System.out.println("------- Down Salary -------");
        while (true) {
            System.out.print("Enter Id: ");
            String id = Validation.inputString();
            if (Validation.checkID(list, id)) {
                System.out.println("ID hasn't exist! Please enter again: ");
                continue;
            }
            for (Worker input : list) {
                System.out.printf("%-17s %-20s %-20s %-20s %-20s\n", "ID", "Name", "Age", "Salary", "Work location");
                if (id.equalsIgnoreCase(input.getId())) {
                    input.display();
                    System.out.println("");
                    while (true) {
                        System.out.print("Enter values: ");
                        float psala = Validation.salaryCheck();
                        if (psala < input.getSalary()) {
                            System.out.println("The value of the salary after the change is less than 0: " + (input.getSalary() - psala));
                            System.out.println("Please try again: ");
                            continue;
                        }
                        float x = input.getSalary() - psala;
                        input.setSalary(x);
                        System.out.println("Done");
                        input.display();
                    }
                }
            }
            return ;
        }
    }

    public static void output() {
        System.out.printf("%-17s %-20s %-20s %-20s %-20s\n", "ID", "Name", "Age", "Salary", "Work location");
        for (Worker s : list) {
            s.display();
        }
    }

}
