package university;

public class Student {
	private String name, surname;
	private int ID;

	private int [] attendedCourses = new int [25];
	
	private int attending = 0;
	
	public Student(String name, String surname, int ID) {
		this.name = name;
		this.surname = surname;
		this.ID = ID;
	}
	
	public String toString () {
		return ID + " " + name + " " + surname;
	}
	
	public void setCourse (int idCourse){
		attendedCourses[attending++] = idCourse;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getAttending() {
		return attending;
	}

	public int getCourse(int id) {
		return attendedCourses[id];
	}

}