
package P0056;
import static P0056.Manager.addWorker;
import static P0056.Manager.downSalary;
import static P0056.Manager.output;
import static P0056.Manager.upSalary;
public class MyMain {
    public static void main(String[] args){
        int check = 1;
        do{
            System.out.println("");
            System.out.println("======= Worker Management =======");
            System.out.println("1. Add Worker");
            System.out.println("2. Up Salary");
            System.out.println("3. Down Salary");
            System.out.println("4. Display infomation");
            System.out.println("5. Write File");
            System.out.println("6. Read File");
            System.out.println("7. Exit");
            System.out.println("=================================");
            System.out.print("Please choose: ");
            int choice = Validation.checkInt();
            switch (choice){
                case 1:
                    addWorker();
                    break;
                case 2:
                    upSalary();
                    break;
                case 3:
                    downSalary();
                    break;
                case 4:
                    output();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("See you later");
                    check = 0;
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }while (check == 1);
    }
}
