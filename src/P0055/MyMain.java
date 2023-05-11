package P0055;


import java.io.IOException;

public class MyMain {
    public static void main(String[] args) throws IOException {
        Manager manager = new Manager();
        int chose;
        do{
            System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
            System.out.println("\t1. Add Doctor");
            System.out.println("\t2. Updeat Doctor");
            System.out.println("\t3. Delete Doctor");
            System.out.println("\t4. Display Information Doctors: ");
            System.out.println("\t5. Search Doctor");
            System.out.println("\t6. Read file");
            System.out.println("\t7. Save file");
            System.out.println("\t8. Exit");
            System.out.print("Enter your choice: ");
            chose = Validation.inputInt();
            switch (chose) {
                case 1:
                    manager.addDoctors();
                    break;
                case 2:
                    manager.updeatDoctors();
                    break;
                case 3:
                    manager.deleteDoctors();
                    break;
                case 4:
                    manager.display();     
                    break;
                case 5:
                    manager.searchDoctor();
                    break;
                case 6:
                    manager.readFile("file.txt");
                    break;
                case 7:
                    manager.saveFormFile("file.txt");
                    break;
                default:
                    System.out.println("Goodbye.");
            
            }
        }while (chose <=7 && chose > 0 );
    }
    
    
    
    
    
}
