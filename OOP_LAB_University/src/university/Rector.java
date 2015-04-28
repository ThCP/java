package university;

public class Rector {
	String name, surname;

	
	public Rector(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public String toString() {
		return name + " " + surname;
	}
}
