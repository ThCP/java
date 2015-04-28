package company;

public class ExampleEmployee {

	public static void main(String[] args) {
		
		Employee e = new Employee("John Smith",20000);
		Employee m = new Manager("Mario Rossi",3000,"Finance");

		//e.print();
		//m.print();
		
		System.out.println( e.toString() );
		
		System.out.println( m.toString() );
		
		
		Employee a = new Employee("Mary Smith",30000);
		Employee b = new Employee("Mary Smith",30000);
		
//		if( a == b){
//			System.out.println("a == b  is true");
//		}
//		
//
//		if( a.equals(b) ){
//			System.out.println("a.equals(b)  is true");
//		}
//
//		boolean crazyComparison = a.equals("Mary Smith");
		
		
		comparisons(a,b);
		comparisons(a,"Mary Smith");
		comparisons(a,null);
		comparisons(a,a);
		
		System.out.println(a);
		// SAME RESULT AS
		System.out.println(a.toString());
		
	}
	
	static void comparisons(Object a, Object b){
		System.out.println("Comparing " + a + " to " + b);
		System.out.println("a == b  is " + (a==b) );
		

		System.out.println("a.equals(b)  is " + a.equals(b));

	}
	
	

}
