/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0051;

/**
 *
 * @author ADMIN
 */
public class MyMain {
     public static void main(String[] args) {
        //loop until user want to exit
        while (true) {
            int choice = Manager.mennu();
            switch (choice) {
                case 1:
                    Manager.normalCalculator();
                    break;
                case 2:
                    Manager.BMICalculator();
                    break;
                case 3:
                    return;
            }
        }

    }
    
}










