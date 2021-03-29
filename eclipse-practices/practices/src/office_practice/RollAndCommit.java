package office_practice;

import java.util.ArrayList;
import java.util.Scanner;
public class RollAndCommit{
	static String userGuide="press 3 for commit, 4 for rollback, press 5 enter data,\n press 6 get stuent data,press 7 get employee data,\n press 8 close connection, press 9 create connection";
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
		userFriendly(execute);
		break;
		case 4:execute.removeChanges();
		userFriendly(execute);
		break;
		case 5:entryData(execute);
		break;
		case 6:ArrayList<Student>studentList =execute.getStudentData();
		for(Student student:studentList) {
			System.out.println("student id: "+student.getId()+" student name: "+student.getName()+" student age: "+student.getAge()+" student hometown: "+student.getHometown());
		}
		userFriendly(execute);
		break;
		case 7:ArrayList<Employee>employeeList =execute.getEmployeeData();
		for(Employee employee:employeeList) {
			System.out.println("employee id: "+employee.getId()+" employee name: "+employee.getName()+" employee age: "+employee.getAge()+" employee hometown: "+employee.getHometown()+" employee designation: "+employee.getDesignation());
		}
		userFriendly(execute);
		break;
		case 8:execute.closeConnection();
		scanner.close();
		userFriendly(execute);
		break;
		case 9:System.out.println("connection created........");
		execute.createConnection();
		entryData(execute);
		break;
		default:System.out.println("retry");
		userFriendly(execute);	
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
			System.out.println();
			if(age!=0) {
				System.out.print("enter home town: ");
				String hometown=scanner.next();
				System.out.println();
				if(hometown!=null) 
					execute.insertData(id,name,age,hometown);
				userFriendly(execute);
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
					userFriendly(execute);
				}
			}
		}
		}
		
	}
	public static void commit(Executable execute) {
		execute.applyChanges();
		userFriendly(execute);
	}
	public static void rollback(Executable execute) {
		execute.removeChanges();
		userFriendly(execute);
	}
	public static void userFriendly(Executable execute) {
		System.out.println(userGuide);
		rollAndCommit(execute);
	}
}


	



