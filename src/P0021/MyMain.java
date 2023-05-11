package P0021;

import java.util.ArrayList;

public class MyMain {

    public static void main(String[] args) {
        Manager manager = new Manager();
        int choice;
        do{
            System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
            System.out.println("\t1. Create");
            System.out.println("\t2. Find and Sort");
            System.out.println("\t3. Update/Delete");
            System.out.println("\t4. Report");
            System.out.println("\t5. Read file");
            System.out.println("\t6. Save file");
            System.out.println("\t7. Exit");
            System.out.print("Enter your choice: ");
            choice = Validation.inputInt();
            System.out.println("---------------------------------");
            switch (choice) {
                case 1:
                    manager.createStudent();
                    break;
                case 2:
                    manager.findAndsort();
                    break;
                case 3:
                    manager.updateOrDelete();
                    break;
                case 4:
                    manager.report();
                    break;
                case 5:
                    manager.check_readFile();
                    break;
                case 6:
                    manager.check_writeFile();
                    break;
                default:
                    System.err.println("Thanks and Goodbye");
            }
        }while(choice>0 && choice <7 );
    }
}
