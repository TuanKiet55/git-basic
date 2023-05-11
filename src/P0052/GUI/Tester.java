package P0052.GUI;

import static P0052.GUI.Manage_East_Asia_Countries.ValidateInt;
import static P0052.GUI.Manage_East_Asia_Countries.addCountryInformation;
import static P0052.GUI.Manage_East_Asia_Countries.getRecentlyEnteredInformation;
import static P0052.GUI.Manage_East_Asia_Countries.menu;
import static P0052.GUI.Manage_East_Asia_Countries.searchInformationByName;
import static P0052.GUI.Manage_East_Asia_Countries.sortInformationByAscendingOrder;


public class Tester {
    
     
    
    public static void main(String[] args) {
        int userchoice;
        String a[] = {"Enter the information for 11 countries in Southeast Asia."
                ,"Display already information."
                ,"Search the country according to the entered country's name."
                ,"Display the information increasing with the country name.","Exit."};       
        do{
            menu(a);
            userchoice = ValidateInt();
            System.out.println("==========================================================================");
            switch (userchoice) {
                case 1:
                    addCountryInformation();
                    break;
                case 2:
                    getRecentlyEnteredInformation();
                    break;
                case 3:
                    searchInformationByName();
                    break;
                case 4:
                    sortInformationByAscendingOrder();
                    break;
                default:
                    System.out.println("Goodbye! See you late.");
            }
        }while(userchoice > 0 && userchoice < 5);
    }
}