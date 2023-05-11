package P0076;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    static Scanner scan = new Scanner(System.in);
    static private ArrayList<CSV> ls = new ArrayList<>();

    public static int inputLimit(int a, int b) {
        while (true) {
            try {
                int result = scan.nextInt();
                if (result < a || result > b) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.out.println("Enter again: ");
            }
        }
    }

    public static int menu() {
        System.out.println("====== Format CSV Program ======");
        System.out.println("1. Import SCV");
        System.out.println("2. Format Address");
        System.out.println("3. Format Name");
        System.out.println("4. Export CSV");
        System.out.println("5. Print CSV");
        System.out.println("6. Exit");
        System.out.println("Please choice one option: ");
        int n = inputLimit(1, 6);
        return n;
    }

    public static void fomatName() {
        for (int i = 0; i < ls.size(); i++) {
            String name = ls.get(i).getName();
            name = name.toLowerCase().replace("\\s+", ",");
            String[] s = name.split(",");
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < s.length; j++) {
               sb.append(Character.toLowerCase(s[j].charAt(0))).append(s[j].substring(1)).append(" ");
    
            }
            ls.get(i).setName(sb.toString().trim());
        }
    }

    public static void fomartAddress() {
        for (int i = 0; i < ls.size(); i++) {
            String adr = ls.get(i).getAddress();
            adr = adr.toLowerCase().replaceAll("\\s+", ",");
            String[] s = adr.split(",");
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < s.length; j++) {
                sb.append(Character.toLowerCase(s[j].charAt(0))).append(s[j].substring(1)).append(" ");
            }
            ls.get(i).setAddress(sb.toString().trim());
        }
    }

    public static void writeFile(String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            for (CSV csv : ls) {
                bw.write(csv.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void printList() {
        for (CSV csv : ls) {
            System.out.println(csv);
        }
    }

    public static void readFile(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            try ( BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] txt = line.split(",");
                    ls.add(new CSV(Integer.parseInt(txt[0].trim()), txt[1], txt[2], txt[3], txt[4]));
                }
                br.close();
                fr.close();
                System.out.println("Read file success");
                return;
            }
        } catch (Exception e) {
//			e.printStackTrace();
            System.out.println("invalid file name");
        }
    }

    // src\P0076\input.txt
   // src\P0076\output.txt
    public static void main(String[] args) {
        while (true) {
            int i = menu();
            switch (i) {
                case 1:
                    System.out.println("Enter path: ");
                    scan = new Scanner(System.in);
                    String input = scan.nextLine().trim();
                    readFile(input);
                    break;
                case 2:
                    if (ls.isEmpty()) {
                        System.out.println("list is empty");
                        break;
                    }
                    fomartAddress();
                    System.out.println("Format done");
                    break;
                case 3:
                    if (ls.isEmpty()) {
                        System.out.println("list is empty");
                        break;
                    }
                    fomatName();
                    System.out.println("format done");
                    break;
                case 4:
                    if (ls.isEmpty()) {
                        System.out.println("list is empty");
                        break;
                    }
                    System.out.println("Enter path: ");
                    scan = new Scanner(System.in);
                    String output = scan.nextLine();
                    writeFile(output.trim());

                    break;
                case 5:
                    printList();
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }
}
