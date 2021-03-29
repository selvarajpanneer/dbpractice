package office_practice;

import java.util.ArrayList;
import java.util.Scanner;
public class RollAndCommit{
	public static void main(String[] args) {
		Executable execute= new SqlUtil();
		execute.createConnection();
		execute.createTable();
	System.out.println("choose person: student press 1 , employee press 2");
	entryData(execute);
	}
	private static void entryData(Executable execute) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		switch(input) {
		case 1:studentEntry(scanner,execute);
		break;
		case 2:employeeEntry(scanner,execute);
		break;
		default:
			System.out.println("thanks for visit ");
		}	
	}
	
	private static void rollAndCommit(Executable execute) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		switch(input) {
		case 3:execute.applyChanges();
		System.out.println("press 3 for commit, 4 for rollback, press 5 enter data, press 6 get stuent data,press 7 get employee data, press 8 close connection, press 9 create connection");
		rollAndCommit(execute);
		break;
		case 4:execute.removeChanges();
		System.out.println("press 3 for commit, 4 for rollback, press 5 enter data, press 6 get stuent data,press 7 get employee data, press 8 close connection, press 9 create connection");
		rollAndCommit(execute);
		break;
		case 5:entryData(execute);
		break;
		case 6:execute.getStudentData();
		System.out.println("press 3 for commit, 4 for rollback, press 5 enter data, press 6 get stuent data,press 7 get employee data, press 8 close connection, press 9 create connection");
		rollAndCommit(execute);
		break;
		case 7:execute.getEmployeeData();
		System.out.println("press 3 for commit, 4 for rollback, press 5 enter data, press 6 get stuent data,press 7 get employee data, press 8 close connection, press 9 create connection");
		rollAndCommit(execute);
		break;
		case 8:execute.closeConnection();
		System.out.println("press 3 for commit, 4 for rollback, press 5 enter data, press 6 get stuent data,press 7 get employee data, press 8 close connection, press 9 create connection");
		rollAndCommit(execute);
		break;
		case 9:System.out.println("connection created........");
			execute.createConnection();
		}
	}
	private static void studentEntry(Scanner scanner,Executable execute) {
		//student
		System.out.println("enter student details: below");
		System.out.print("enter id: ");
		int id=scanner.nextInt();
		System.out.println();
		if(id!=0) {
			System.out.print("enter name: ");
			String name=scanner.next();
			System.out.println();
		
		if(name!=null) {
			System.out.print("enter age: ");
			int age=scanner.nextInt();
			String ageString=String.valueOf(age);
			System.out.println();
			if(age!=0) {
				System.out.print("enter home town: ");
				String hometown=scanner.next();
				System.out.println();
				if(hometown!=null) 
					execute.insertData(id,name,age,hometown);
					System.out.println("press 3 for commit, 4 for rollback, press 5 enter data, press 6 get stuent data,press 7 get employee data, press 8 close connection, press 9 create connection");
					rollAndCommit(execute);
			}
		}
		}	
	}
	private static void employeeEntry(Scanner scanner,Executable execute) {
		//employee
		System.out.println("enter employee details: below");
		System.out.print("enter id: ");
		int id=scanner.nextInt();
		System.out.println();
		if(id!=0) {
			System.out.print("enter name: ");
			String name=scanner.next();
			System.out.println();
		if(name!=null) {
			System.out.print("enter age: ");
			int age=scanner.nextInt();
			System.out.println();
			if(age!=0) {
				System.out.print("enter hometown: ");
				String hometown=scanner.next();
				System.out.println();
				if(hometown!=null) {
					System.out.print("enter designation:");
					String designation=scanner.next();
					if(designation!=null)
					execute.insertData(id, name, age, hometown, designation);
					System.out.println("press 3 for commit, 4 for rollback, press 5 enter data, press 6 get stuent data,press 7 get employee data, press 8 close connection, press 9 create connection");
					rollAndCommit(execute);
				}
			}
		}
		}
		
	}
	public static void commit(Executable execute) {
		execute.applyChanges();
		System.out.println("press 5 for get student record, press 6 for get employee record");
	}
	public static void rollback(Executable execute) {
		execute.removeChanges();
	}
}


	



