package office_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlUtil implements Executable {
	ArrayList<Student> studentList;
	ArrayList<Employee> employeeList;
	private final static String URL = "com.mysql.jdbc.Driver";
	private final static String CREDENTIAL = "jdbc:mysql://localhost:3306/selva";
	private final static String USER_NAME = "ksr94";
	private final static String PASSWORD = "$elvaDB1";
	private final static String EMPLOYEE_TABLE = "CREATE TABLE IF NOT EXISTS employee(serialno INT AUTO_INCREMENT PRIMARY KEY, "
			+ "id INT,name VARCHAR(255) NOT NULL, age INT, hometown VARCHAR(255), designation VARCHAR(255))";
	private final static String STUDENT_TABLE = "CREATE TABLE IF NOT EXISTS student(serialno INT AUTO_INCREMENT PRIMARY KEY,id INT,name VARCHAR(50),age INT,hometown VARCHAR(100))";
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	ArrayList<Person> selectPerson = new ArrayList<Person>();

	public void createConnection() {
		if (connection == null) {
			try {
				Class.forName(URL);
				connection = (Connection) DriverManager.getConnection(CREDENTIAL, USER_NAME, PASSWORD);
				connection.setAutoCommit(false);
				statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void createTable() {
		execute(EMPLOYEE_TABLE);
		execute(STUDENT_TABLE);
	}

	public void applyChanges() {
		if (connection != null) {
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void removeChanges() {
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public void closeConnection() {
		try {
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void insertData(int id, String name, int age, String hometown) {
		String sql = "INSERT INTO student(id,name,age,hometown) VALUES(?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4, hometown);
			int rowAffected = preparedStatement.executeUpdate();
			preparedStatement.close();
			if (rowAffected == 1) {
				System.out.println("data inserted successfully...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertData(int id, String name, int age, String hometown, String designation) {
		String insert = "INSERT INTO employee(id,name,age,hometown,designation) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insert, statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4, hometown);
			preparedStatement.setString(5, designation);
			int rowAffected = preparedStatement.executeUpdate();
			preparedStatement.close();
			if (rowAffected == 1) {
				System.out.println("data inserted successfully...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void execute(String query) {
		try {
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList<Student> getStudentData() {
		ArrayList<Student> temporaryStudentList = new ArrayList<Student>();
		String sql = "select * from student";
		ResultSet studentResult = null;
		try {
			studentResult = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("student data");
		try {
			while (studentResult.next()) {
				temporaryStudentList.add(new Student(studentResult.getInt(2), studentResult.getString(3),
						studentResult.getInt(4), studentResult.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		studentList = temporaryStudentList;
		return studentList;
	}

	public ArrayList<Employee> getEmployeeData() {
		String sql = "select * from employee";
		ArrayList<Employee> temporaryEmployeeList = new ArrayList<Employee>();
		ResultSet employeeResult = null;
		try {
			employeeResult = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("employee data");
		try {
			while (employeeResult.next()) {
				temporaryEmployeeList.add(new Employee(employeeResult.getInt(2), employeeResult.getString(3),
						employeeResult.getInt(4), employeeResult.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employeeList = temporaryEmployeeList;
		return employeeList;
	}
}
