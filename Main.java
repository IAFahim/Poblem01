package EmployeeWithFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

interface PayableTax{
	int TAXPERCENTAGE = 15;
	double yearlyTaxfreeIncome();
	double yearlyTaxableIncome();
	double getIncomeTax();
}

abstract class Salary{
	public abstract double yearlySalary();
	public abstract double yearlyBonus();
	public abstract double yearlyNetIncome();
}

class Employee extends Salary implements PayableTax{
	private String Name;
	private String Gender;
	private String NID;
	private String TIN;
	private double MonthlySalary;
	
	public Employee() {
		
	}

	public Employee(String name, String gender, String nid, String tin) {
		Name = name;
		Gender = gender;
		NID = nid;
		TIN = tin;
	}

	public String getName() {
		return Name;
	}

	public String getGender() {
		return Gender;
	}

	public String getNID() {
		return NID;
	}

	public String getTIN() {
		return TIN;
	}
	
	public String toString() {
		return "Employee [Name=" + Name + ", Gender=" + Gender + ", NID=" + NID + ", TIN=" + TIN + ", MonthlySalary="
				+ MonthlySalary + "]";
	}
	
	public void setMonthlySalary(double amount) {
		MonthlySalary = amount;
	}

	public double yearlyTaxfreeIncome() {
		String g = "Male";
		double i1 = 300000;
		double i2 = 450000;
		
		if(getGender().equalsIgnoreCase(g)) {
			return i1;
		}
		return i2;
	}

	public double yearlyTaxableIncome() {
		return yearlyNetIncome() - yearlyTaxfreeIncome();
	}

	public double getIncomeTax() {
		return yearlyTaxableIncome()*(TAXPERCENTAGE/100);
	}


	public double yearlySalary() {
		return MonthlySalary*12;
	}


	public double yearlyBonus() {
		return MonthlySalary*2;
	}


	public double yearlyNetIncome() {
		return yearlySalary()+yearlyBonus();
	}
	
}

class Faculty extends Employee{
	private double basicSalary;
	private double allowance;
	
	public Faculty() {
		
	}
	
	public Faculty(String name, String gender, String nid, String tin, double basic) {
		super(name, gender, nid, tin);
		basicSalary = basic;
	}

	public void setAllowance() {
		allowance = basicSalary*0.5;
	}
	
	public double getBasicSalary() {
		return basicSalary;
	}
	
	public String toString() {
		return "Faculty [basicSalary=" + basicSalary + ", allowance=" + allowance + "]";
	}
	
}

public class Main {
	public static Faculty[] f = new Faculty[10];
	
	public static void loadFile() {
		Scanner input = new Scanner(System.in);
		System.out.println("Number of Faculties:");
		int numf = input.nextInt();
		
		try {
			for(int i=0; i<=numf-1; i++) {
				System.out.println("Enter your full name:");
				String name = input.nextLine();
				System.out.println("Enter your gender:");
				String gender = input.nextLine();
				System.out.println("Enter your NID No:");
				String nid = input.nextLine();
				System.out.println("Enter your TIN No:");
				String tin = input.nextLine();
				System.out.println("Enter your Monthly Income:");
				double mincome = input.nextDouble();

				f [i] = new Faculty(name, gender, nid, tin, mincome);
				
				input.close();
			}
		}
			catch(Exception e2) {
				System.out.println("ERROR 404! File-Not-Found(02)");
			}
		
	}
	
	public static void toFile() {
		try {
			String path1 = "C:\\Users\\ArMan\\Desktop\\eclipse-workspace\\CSE215L_Assignment\\src\\EmployeeWithFile\\Files\\employees.txt";
			FileWriter write1 = new FileWriter(path1, true);
			for(int i=0; i<f.length; ++i) {
				write1.write(f[i].getName()+ " "+f[i].getGender()+" "+f[i].getNID()+" "+f[i].getTIN()+" "+f[i].getNID()+"\n");
			}
			write1.close();
		}
		catch(Exception e1) {
			System.out.println("ERROR 404! File-Not-Found(01)");
		}
		
	}
	
	public static int noOfFaculties() {
		String path2 = "C:\\Users\\ArMan\\Desktop\\eclipse-workspace\\CSE215L_Assignment\\src\\EmployeeWithFile\\Files\\employees.txt";
		int count = 0;
		try {
			FileReader fr = new FileReader(path2);
			try(BufferedReader br = new BufferedReader(fr)){
				while((br.readLine()) != null) {
					count++;
				}
				br.close();
			}
			catch(Exception e4){
				System.out.println("ERROR 404! File-Not-Found(04)");
			}
			fr.close();
		}
		catch(Exception e3){
			System.out.println("ERROR 404! File-Not-Found(03)");
		}
		
		return count;
		
	}
	
	public static void main(String arg[]) {
		Faculty f1 = new Faculty();
		
		loadFile();
		toFile();
		System.out.println("Number of Faculties Data Store: "+noOfFaculties());
		
		Faculty [] arrf = new Faculty[10];
		
		for(int i=0; i<=noOfFaculties()-1; i++) {
			arrf [i] = new Faculty(getIncomeTax);
		}
		
		try {
			String path3 = "C:\\Users\\ArMan\\Desktop\\eclipse-workspace\\CSE215L_Assignment\\src\\EmployeeWithFile\\Files\\employeesTaxReport.txt";
			FileWriter write2 = new FileWriter(path3, true);
			for(int i=0; i<=noOfFaculties()-1; ++i) {
				write2.write("Tax Amount: "+f1.getIncomeTax()+" tk"+"Taxpayer Name: " +f.getName()+" "+f[i].getNID()+"\n");
			}
			write2.close();
		}
		catch(Exception e1) {
			System.out.println("ERROR 404! File-Not-Found(01)");
		}
	}
}
