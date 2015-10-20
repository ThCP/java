import clinic.Clinic;


public class ExampleApp {

	public static void main(String[] args) {

		Clinic clinic = new Clinic();

		clinic.addPatient("Alice", "Green", "ALCGRN");
		clinic.addPatient("Robert", "Smith", "RBTSMT");
		clinic.addPatient("Steve", "Moore", "STVMRE");
		clinic.addPatient("Susan", "Madison", "SSNMDS");

		System.out.println("Added patients");
		
		clinic.addDoctor("George", "Sun","SNUGRG", 14,"Physician");
		clinic.addDoctor("Kate", "Love", "LVOKTA",86,"Physician");

		System.out.println("Added doctors");
		
		try {
			clinic.assignPatientToDoctor("SSNMDS", 86);
			clinic.assignPatientToDoctor("ALCGRN", 14);
			clinic.assignPatientToDoctor("RBTSMT", 14);
			clinic.assignPatientToDoctor("STVMRE", 14);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("Patients assigned");

		try {
			clinic.getDoctor(-1);
		} catch (Exception ex) {
			System.out.println("As expected we got the following exception for doctor -1:" + ex);
		}
	
		try {
//			clinic.loadData("C:\\Users\\Riccardo\\Programmazione\\workspace\\OOP_LAB_Clinic\\testo.txt");
			clinic.loadData("C:\\Users\\Riccardo\\Programmazione\\workspace\\OOP_LAB_Clinic\\clinic\\tex2");
			
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println(clinic.getDoctors());
		System.out.println(clinic.getPatients());
		
		System.out.println(clinic.idleDoctors());
		System.out.println(clinic.busyDoctors());
		
		System.out.println(clinic.doctorsByNumPatients());

		System.out.println(clinic.countPatientsPerSpecialization());

		
	}

}
