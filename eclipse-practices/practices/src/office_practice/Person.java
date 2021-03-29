package office_practice;

public class Person {
	int id;
	String name;
	int age;
	String hometown;
	String designation;

	public Person(int id, String name, int age, String hometown) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.hometown = hometown;
	}

	public Person(int id, String name, int age, String hometown, String designation) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.designation = designation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public static void main(String[] args) {

	}

}
