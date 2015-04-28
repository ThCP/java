package processor;

public class ProcessorExample {
	
	
	static void process(Object[] v, Processor p){
		  for(Object o : v){
			  if( p.isValid(o) ){
				  p.handle(o);
			  }else{
				  System.out.println("Invalid element: " + o);
			  }
			  
		  }
		}

	
	
	public static void main(String[] args){
		
		String[] v = {"A","B","C","D"};

		// Using an external stand-alone class:
		//Processor printer = new Printer();

		// Using a nested class:
		//Processor printer = new NestedPrinter();
		
		// Using an anonymous inner class
//		Processor printer = new Processor(){
//			public void handle(Object o){
//				System.out.println(o);
//			}
//		};
//		process(v,printer);
		
		process(v,new Processor(){
			public void handle(Object o){
				System.out.println(o);
			}
		});
		
		// Since Java 8
		// Using lambda expressions
		process(v, o -> System.out.println(o)); // lamda expression
		
		// Using a method reference
		process(v, System.out::println ); 
		
	}
	
	public static class NestedPrinter implements Processor {
		@Override
		public void handle(Object o) {
			System.out.println(o);	
		}
	}

}
