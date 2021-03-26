package office_practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;




public class RollandCommit{
	
	public static void main(String[] args) {
		ArrayList<Employee> emp= new ArrayList<Employee>();
		ArrayList<Student> student = new ArrayList<Student>();
		
		try{  
			
			Class.forName("com.mysql.jdbc.Driver");  
		
			Connection con=(Connection) DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/test","ksr94","$elvaDB1");  
			con.setAutoCommit(false);
			  
			Statement stmt=(Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);   
			
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS employee(serialno INT AUTO_INCREMENT PRIMARY KEY, "+
                    "empid 	INT, empname VARCHAR(255) NOT NULL, age INT,designation VARCHAR(255))");
				stmt.executeUpdate("insert into employee(empid,empname,age,designation) "+
                    "values(12341,'raj',25,'engineer');");
				stmt.executeUpdate("insert into employee(empid,empname,age,designation) "+
	                    "values(12342,'ramesh',24,'junior engineer');");
				stmt.executeUpdate("insert into employee(empid,empname,age,designation) "+
	                    "values(12343,'mani',25,'accountant');");
				con.rollback();
				con.commit();
				int i=0;
				while(i<1000) {
					i++;
				}
				
				//after commit
				System.out.println("after commit");
				ResultSet rs= stmt.executeQuery("select * from employee");
				while(rs.next()) {
					emp.add(new Employee(rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
				}
				for(Employee e:emp) {
					System.out.println(e.getEmpid()+" "+e.getEmpname()+" "+e.empage+" "+e.getDesignation());
				}
				System.out.println("student record");
				ResultSet rs_stud1= stmt.executeQuery("select * from student");
				while(rs_stud1.next())  {
					student.add(new Student(rs_stud1.getInt(2),rs_stud1.getString(3),rs_stud1.getInt(4),rs_stud1.getString(5)));
					}
				for(Student s: student) {
					System.out.println("rollno: "+s.getRollno()+" name: "+s.getName()+" age: "+s.getAge()+" hometown: "+s.getHometown());	
				}
				
				//add employee and student operation
				stmt.executeUpdate("insert into employee(empid,empname,age,designation) "+
	                    "values(12344,'priya',25,'hr');");
				stmt.executeUpdate("insert into employee(empid,empname,age,designation) "+
	                    "values(12345,'ragu',22,'clerk');");
				//before roll back
				System.out.println("before rollback");
				System.out.println("employee record");
				//employee after roll back
				ResultSet rs1= stmt.executeQuery("select * from employee");
				while(rs1.next()) {
					emp.add(new Employee(rs1.getInt(2),rs1.getString(3),rs1.getInt(4),rs1.getString(5)));
				}
				for(Employee e:emp) {
					System.out.println(e.getEmpid()+" "+e.getEmpname()+" "+e.empage+" "+e.getDesignation());
				}
				//student after roll back
				System.out.println("student record");
				ResultSet rs_stud2= stmt.executeQuery("select * from student");
				while(rs_stud2.next())  {
					student.add(new Student(rs_stud2.getInt(2),rs_stud2.getString(3),rs_stud2.getInt(4),rs_stud2.getString(5)));
					}
				for(Student s: student) {
					System.out.println("rollno: "+s.getRollno()+" name: "+s.getName()+" age: "+s.getAge()+" hometown: "+s.getHometown());	
				}
				con.rollback();
				//after roll back
				System.out.println("after rollback");
				System.out.println("employee record");
				//employee after roll back
				ResultSet rs3= stmt.executeQuery("select * from employee");
				while(rs3.next()) {
					emp.add(new Employee(rs3.getInt(2),rs3.getString(3),rs3.getInt(4),rs3.getString(5)));
				}
				for(Employee e:emp) {
					System.out.println(e.getEmpid()+" "+e.getEmpname()+" "+e.empage+" "+e.getDesignation());
				}
				//student after roll back
				System.out.println("student record");
				ResultSet rs_stud3= stmt.executeQuery("select * from student");
				while(rs_stud3.next())  {
					student.add(new Student(rs_stud3.getInt(2),rs_stud3.getString(3),rs_stud3.getInt(4),rs_stud3.getString(5)));
					}
				for(Student s: student) {
					System.out.println("rollno: "+s.getRollno()+" name: "+s.getName()+" age: "+s.getAge()+" hometown: "+s.getHometown());	
				}

				stmt.close();
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  

	}

}

//employee model
class Employee{
	int empid;
	String empname;
	int empage;
	String designation;
	
	public Employee(int empid,String empname,int empage,String designation) {
		this.empid=empid;
		this.empname=empname;
		this.empage=empage;
		this.designation=designation;
		
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public int getEmpage() {
		return empage;
	}

	public void setEmpage(int empage) {
		this.empage = empage;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
class Student{
	int rollno;
	String name;
	int age;
	String hometown;
	
	public Student(int rollno,String name,int age,String hometown) {
		this.rollno=rollno;
		this.name=name;
		this.age=age;
		this.hometown=hometown;
		
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
}


