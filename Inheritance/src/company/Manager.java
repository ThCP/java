package company;

public class Manager extends Employee {
	
	private String unit;
	
	public Manager(String name, double wage, String unit){
		super(name,wage);  // invoke super class's constructor
		this.unit = unit;
	}
	
	public void print(){
		//System.out.println(name + "( " + unit + " )");
		
		System.out.println( this.getName() + "( " + unit + " )");
		
		super.print();
		System.out.println("( " + unit + " )");
		
	}
	
	public String toString(){
		return super.toString() + " [" + unit + "]";
	}

}
