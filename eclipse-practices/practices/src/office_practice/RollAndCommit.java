package office_practice;

import java.util.ArrayList;
import java.util.Scanner;
public class RollAndCommit{
	public static void main(String[] args) {
		SqlUtil sqlUtil= new SqlUtil();
		sqlUtil.createConnection();
		sqlUtil.createTable();
	System.out.println("choose person: student press 1 , employee press 2");
	entryData(sqlUtil);
	}
	private static void entryData(SqlUtil sqlUtil) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		switch(input) {
		case 1:studentEntry(scanner,sqlUtil);
		break;
		case 2:employeeEntry(scanner,sqlUtil);
		break;
		default:
			System.out.println("thanks for visit ");
		}	
	}
	
	private static void rollAndCommit(SqlUtil sqlUtil) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		switch(input) {
		case 3:sqlUtil.applyChanges();
		System.out.println("press 3 for commit, 4 for rollback, press 5 enter data, press 6 get stuent data,press 7 get employee data, press 8 close connection, press 9 create connection");
		rollAndCommit(sqlUtil);
		break;
		case 4:sqlUtil.removeChanges();
		System.out.println("press 3 for commit, 4 for rollback, press 5 enter data, press 6 get stuent data,press 7 get employee data, press 8 close connection, press 9 create connection");
		rollAndCommit(sqlUtil);
		break;
		case 5:entryData(sqlUtil);
		break;
		case 6:sqlUtil.getStudentData();
		System.out.println("press 3 for commit, 4 for rollback, press 5 enter data, press 6 get stuent data,press 7 get employee data, press 8 close connection, press 9 create connection");
		rollAndCommit(sqlUtil);
		break;
		case 7:sqlUtil.getEmployeeData();
		System.out.println("press 3 for commit, 4 for rollback, press 5 enter data, press 6 get stuent data,press 7 get employee data, press 8 close connection, press 9 create connection");
		rollAndCommit(sqlUtil);
		break;
		case 8:sqlUtil.closeConnection();
		System.out.println("press 3 for commit, 4 for rollback, press 5 enter data, press 6 get stuent data,press 7 get employee data, press 8 close connection, press 9 create connection");
		rollAndCommit(sqlUtil);
		break;
		case 9:System.out.println("connection created........");
			sqlUtil.createConnection();
		}
	}
	private static void studentEntry(Scanner scanner,SqlUtil sqlUtil) {
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
					sqlUtil.insertData(id,name,age,hometown);
					System.out.println("press 3 for commit, 4 for rollback, press 5 enter data, press 6 get stuent data,press 7 get employee data, press 8 close connection, press 9 create connection");
					rollAndCommit(sqlUtil);
			}
		}
		}	
	}
	private static void employeeEntry(Scanner scanner,SqlUtil sqlUtil) {
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
					sqlUtil.insertData(id, name, age, hometown, designation);
					System.out.println("press 3 for commit, 4 for rollback, press 5 enter data, press 6 get stuent data,press 7 get employee data, press 8 close connection, press 9 create connection");
					rollAndCommit(sqlUtil);
				}
			}
		}
		}
		
	}
	public static void commit(SqlUtil sqlUtil) {
		sqlUtil.applyChanges();
		System.out.println("press 5 for get student record, press 6 for get employee record");
	}
	public static void rollback(SqlUtil sqlUtil) {
		sqlUtil.removeChanges();
	}
	public void printData(ArrayList<Person> student) {
		
		
	}
	
}


	



