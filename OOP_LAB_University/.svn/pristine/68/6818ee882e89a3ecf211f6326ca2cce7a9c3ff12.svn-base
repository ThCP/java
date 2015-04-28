package university;

public class Course {
	private String name;
	private String professor;
	private int ID;
	private int [] attendingStudents = new int[100];
	private int attending = 0;
	
	public Course(String name, String professor, int ID) {
		this.name = name;
		this.professor = professor;
		this.ID = ID;
	}
	
	public String toString (){
		return ID + " " + name + " " + professor;
	}
	
	public void setStudent (int idStudent){
		attendingStudents[attending++] = idStudent; 
	}
	
	public int getStudent(int id) {
		return attendingStudents[id];
	}


	public int getAttending() {
		return attending;
	}

	
}
