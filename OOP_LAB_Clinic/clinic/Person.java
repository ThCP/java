package clinic;

import clinic.Doctor;

public class Person {
	
	private String SSN;
	private String first, last;
	private Doctor doctor;
	
	public Person(String SSN, String first, String last) {
		super();
		this.SSN = SSN;
		this.first = first;
		this.last = last;
	}

	public String getSSN(){
		return SSN;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return first + " " + last + " " + SSN;
	}
	
	
}
