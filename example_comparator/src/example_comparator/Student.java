package example_comparator;

public class Student implements Comparable<Student> {

	private String name, surname, id;
	private int numericId;

	@Override
	public int compareTo(Student arg0) {
		return this.getId().compareTo(arg0.getId());
	}
	
	public Student(String name, String surname, String id, int numericId) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.numericId = numericId;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getId() {
		return id;
	}

	public int getNumericId() {
		return numericId;
	}

	@Override
	public String toString() {
		return name + " " + surname + " " + id;
	}
}
