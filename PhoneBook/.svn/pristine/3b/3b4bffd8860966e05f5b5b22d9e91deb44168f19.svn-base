import phonebook.*;

public class ExampleApp {
	
	public static void main(String[] args) {
		// creates a new PhoneBook object
		PhoneBook pb = new PhoneBook("Personal book");
		
		// ..prints its label
		System.out.println( pb.getLabel() );
		
		// ..adds three contacts
		pb.add("Alice", "Green", "555-1234");
		pb.add("Mary", "Smith", "555-6784");
		pb.add("Bob", "Moore", "555-9756");
		
		// ..prints the whole phone book
		System.out.println( pb.toString() );

		// ..prints the first contact
		System.out.println( pb.first() );

		// ..prints the second contact
		System.out.println( pb.get(2) );

		// ..search for an element
		String toBeFound = new String("Moore");
		System.out.println( pb.find(toBeFound) );	}
}
