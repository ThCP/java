package trail;

public class Delegate implements Comparable<Delegate> {

	private String name;
	private String surname;
	private String id;
	
	public Delegate(String name, String surname, String id) {
		this.name = name;
		this.surname = surname;
		this.id = id;
	}
	
	/**
	 * Format: "Surname, Name, SSN"
	 */
	@Override
	public String toString(){
		return surname + ", " + name + ", " + id;
	}

	@Override
	public int compareTo(Delegate o) {
		int ds = this.surname.compareTo(o.surname);
		if(ds!=0) return ds; 
		return this.name.compareTo(o.name);
	}

}
