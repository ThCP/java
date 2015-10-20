package clinic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;



public class Clinic {

	private Map<String, Person> patients = new HashMap<>(); // map ssn -> person
	private Map<Integer, Doctor> doctors = new HashMap<>(); // map docID -> doctor
	
	public void addPatient(String first, String last, String ssn) { // create a new patient
		Person pp = new Person (ssn, first, last);
		patients.put(ssn, pp); // add the patient to the map
	}

	public void addDoctor(String first, String last, String ssn, int docID, String specialization) { // create a new doctor
		Doctor dd = new Doctor (ssn, first, last, docID, specialization);
		doctors.put(docID, dd); // add the doctor to the map
	}

	public Person getPatient(String ssn) throws NoSuchPatient { 
		
		if (!patients.containsKey(ssn)){ // exception
			throw new NoSuchPatient();
		}
		
		return patients.get(ssn); // returns the patient (if found)
	}

	public Doctor getDoctor(int docID) throws NoSuchDoctor {
		
		if (!doctors.containsKey(docID)){ // exception
			throw new NoSuchDoctor();
		}
		
		return doctors.get(docID); // returns the doctor (if dound)
	}
	
	public void assignPatientToDoctor(String ssn, int docID) throws NoSuchPatient, NoSuchDoctor {
			getPatient(ssn).setDoctor(getDoctor(docID));
			getDoctor(docID).addPatient(getPatient(ssn));
	}
	
	/**
	 * returns the collection of doctors that have no patient at all, sorted in alphabetic order.
	 */
	public Collection<Doctor> idleDoctors(){
		return doctors.values().stream() // create the stream
				// find the doctors who have 0 patients
				.filter(d -> d.getPatients().size() == 0)
				// sort the list by last name
				.sorted (comparing(Doctor::getLast))
				// collect with a list
				.collect(toList());
	}

	/**
	 * returns the collection of doctors that a number of patients larger than the average.
	 */
	public Collection<Doctor> busyDoctors(){
		
		// find the total n. of patients assigned to doctors
		int nPatients = doctors.values().stream()
		//int average = Stream.of(doctors.values())
				.mapToInt( doctor -> new Integer (doctor.getPatients().size()) )
				.reduce(0, (a,b) -> a+b);
		// find  the totat n. of doctors in the clinic
		int nDoctors = doctors.size();
		
		// compute the average
		int average = nPatients / nDoctors;
		
		// filter and return the correct set of doctors
		return doctors.values().stream().filter(d -> d.getPatients().size() > average)
				.collect(toList());
	}

	
	/**
	 * returns list of strings
	 * containing the name of the doctor and the relative number of patients
	 * with the relative number of patients, sorted by decreasing number.<br>
	 * The string must be formatted as "<i>### : ID SURNAME NAME</i>" where <i>###</i>
	 * represent the number of patients (printed on three characters).
	 */
	public Collection<String> doctorsByNumPatients(){
		
		return (Collection<String>) doctors.values().stream().sorted(comparing(d -> getPatients().size()))
			.map(d -> {
						String n = new String(Integer.toString(d.getPatients().size())).format("%03d", new Integer(d.getPatients().size()));
						
						String s = n + " : " + d.getId() + " " + d.getLast() + " " + d.getFirst() + "\n";
						return s;
					}
			)
			.collect(toList());

	}
	
	/**
	 * computes the number of
	 * patients per (their doctor's) specialization.
	 * The elements are sorted first by decreasing count and then by alphabetic specialization.<br>
	 * The strings are structured as "<i>### - SPECIALITY</i>" where <i>###</i>
	 * represent the number of patients (printed on three characters).
	 */
	public Collection<String> countPatientsPerSpecialization(){
		
		Map<String,Long> patientsPerSpecialization = new HashMap<>();
		Collection<String> result = new LinkedList<>();
		
		Set<String> specializations = doctors.values().stream()
		.map(Doctor::getSpecialization)
		.collect(toSet());
		
		specializations.stream().forEach(u -> {
				long count = doctors.values().stream()
						.filter(d -> d.getSpecialization().equals(u))
						.mapToLong(d -> d.getPatients().size())
						.sum();
				patientsPerSpecialization.put(u, count);
		});
		
		for (Map.Entry<String, Long> entry : patientsPerSpecialization.entrySet()){
			result.add(entry.getValue() + " - " + entry.getKey());
		}
		
		return result;
	}
	
	public void loadData(String path) throws IOException {
		try { 
			BufferedReader in = new BufferedReader (new FileReader (path));
			
			String line;
			String [] splits;

			
			while ( (line = in.readLine()) != null) {
				splits = line.split(";");
				for (int i = 0; i < splits.length; i++){
					splits[i] = splits[i].trim();
				}
				
				if (splits[0].equals("P")){
					if (splits.length == 4) {
						this.addPatient(splits[1], splits[2], splits[3]);
					}
				} else {
					if (splits.length == 6) {
						this.addDoctor(splits[2], splits[3], splits[4], new Integer( splits[1] ), splits[5]);
						this.addPatient(splits[2], splits[3], splits[4]);
					}
				}
			}
			
//			BufferedReader in = new BufferedReader ( new FileReader (path) );
//			Pattern csv;
//			Matcher csvMatcher;
//			String line;
//			while ( (line = in.readLine()) != null){
//				csv = Pattern.compile("(P|M);?([0-9])?;([A-Z]+);([A-Z]+);([0-9]+);?([A-Z]+)?");
//				csvMatcher = csv.matcher(line);
//					
//				while (csvMatcher.find()) {
//					System.out.println("Element: " + csvMatcher.group(1));
//					
//					if (csvMatcher.group(1).equals("P")){
//						//System.out.println("Inside");
//						this.addPatient(csvMatcher.group(3), csvMatcher.group(4), csvMatcher.group(5));
//					} else {
//						this.addDoctor(csvMatcher.group(3), csvMatcher.group(4), csvMatcher.group(5), 
//								new Integer (csvMatcher.group(2)), csvMatcher.group(6));
//					}
//						
//				} // end regex while
//				
//			} // end read while
//			in.close();
		} catch (IOException e){
			System.out.println(e.getMessage());
		} // end catch
		
	} // end function

	public Collection<Person> getPatients() {
		return patients.values();
	}

	public Collection<Doctor> getDoctors() {
		return doctors.values();
	}


}
