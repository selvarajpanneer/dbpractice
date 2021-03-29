package office_practice;

public interface Executable {
void createConnection();
void createTable();
void applyChanges();
void removeChanges();
void closeConnection();
void insertData(int id, String name,int age,String hometown);
void insertData(int id, String name,int age,String hometown,String designation);
void getStudentData();
void getEmployeeData();
}
