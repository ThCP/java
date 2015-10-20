package clinic;

import java.util.Collection;
import java.util.LinkedList;

public class Doctor extends Person {

	private int Id;
	private String specialization;
	private Collection<Person> patients = new LinkedList<>();
	
	public Doctor(String SSN, String first, String last, int id,
			String specialization) {
		super(SSN, first, last);
		Id = id;
		this.specialization = specialization;
		patients.add(new Person (first, last, SSN));
	}

	public int getId(){
		return Id;
	}
	
	public String getSpecialization(){
		return specialization;
	}
	
	public Collection<Person> getPatients() {
		return patients;
	}

	public void addPatient(Person patient) {
		patients.add(patient);
	}

	@Override
	public String toString() {
		return super.getFirst() + " " + super.getLast() + " " + super.getSSN()
				+ " " + this.specialization;
	}
	
}
