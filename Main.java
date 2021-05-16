//package EmployeeWithFile;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static Faculty[] f;

    public static void loadFile() {
        try {
            int personSize = noOfFaculties();
            f = new Faculty[personSize];
            String pathToReadFrom = "employees.txt";
            FileInputStream fileInputStream = new FileInputStream(pathToReadFrom);
            Scanner input = new Scanner(fileInputStream);
            for (int i = 0; i < personSize; i++) {
                String name = input.next()+" "+input.next();
                String gender = input.next();
                String nid = input.next();
                String tin = input.next();
                double mincome = input.nextDouble();
                input.nextLine();
                f[i] = new Faculty(name, gender, nid, tin, mincome);
            }
            input.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }

    }

    public static void toFile() {
        try {
            String path3 = "employeesTaxReportTEST.txt";
            FileWriter write2 = new FileWriter(path3, true);
            for (int i = 0; i < noOfFaculties() ; ++i) {
                write2.write("Taxpayer Name: " + f[i].getName() +  "\t|\tTax Amount: " + f[i].getIncomeTax() + " tk\n" );
            }
            write2.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    public static int noOfFaculties() {
        String path2 = "employees.txt";
        int count = 0;
        try {
            FileReader fr = new FileReader(path2);
            try {
                Scanner sc = new Scanner(fr);
                while (sc.hasNextLine()) {
                    sc.nextLine();
                    count++;
                }
                sc.close();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            fr.close();
        } catch (Exception e3) {
            e3.printStackTrace();
        }

        return count;

    }

    public static void main(String arg[]) {
        loadFile();
        toFile();
    }
}
