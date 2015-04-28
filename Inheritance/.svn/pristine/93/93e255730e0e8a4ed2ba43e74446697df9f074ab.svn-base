package company;

public class Employee implements Comparable {
	
	private String name;
	private double wage;

//	public Employee(){
//		
//	}

	public Employee(String name, double wage){
		this.name = name;
		this.wage = wage;
	}
	
	public void print(){
		System.out.println(name);
	}
	
	public String getName(){ return name; }
	
	@Override
	public String toString(){
		return name + "(" + wage + ")";
	}

	@Override
	public boolean equals(Object o){
		if(o==null) return false;
		if( o instanceof Employee){
			Employee other = (Employee)o;
		
			return this.name.equals(other.name) && this.wage==other.wage;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return name.hashCode() + (int)wage;
	}

	@Override
	public int compareTo(Object o) {
		Employee other = (Employee)o;
		
		if( this.wage == other.wage) return 0;
		
		if( this.wage > other.wage) return 1;
		
		return -1;
	}
	
	
	
}
