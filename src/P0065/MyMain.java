package P0065;

public class MyMain {
    
    public static void main(String[] args) {
        Manager manager = new Manager();
        int choice;
        do{
            System.out.println("============Management Student Program============");
            System.out.println("\t1. Input Student");
            System.out.println("\t2. Report");
            System.out.println("\t3. Read File");
            System.out.println("\t4. Write File");
            System.out.println("\t5. Exit");
            System.out.print("Enter your choice: ");
            choice = Validation.inputInt();
            System.out.println("==================================================");
            switch(choice){
                case 1:
                    manager.InputStudent();
                    break;
                case 2:
                    manager.display();
                    break;
                case 3:
                    manager.ReadFile("lab65.txt");
                    break;
                case 4:
                    manager.WriteFile("lab65.txt");
                    break;
                default:
                    System.err.println("Thanks and Goodbye");
            }
        }while(choice>0 && choice < 5);
    }
}
