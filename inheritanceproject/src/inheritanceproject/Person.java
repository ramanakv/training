package inheritanceproject;

public class Person {

	private String name ;
	private String gender;
	private int age;

	public Person(String name, String gender, int age) {

		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Gender: " + gender);
		System.out.println("Age: " + age);
	}

}
