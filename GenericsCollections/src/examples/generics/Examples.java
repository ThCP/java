package examples.generics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class Examples {

	public static void main(String[] args) {
		
		Person[] pa = { new Person(1,"John","Smith"),
						new Person(3,"Mary","White"),
						new Person(2,"Mario","Rossi"),
						new Person(5,"Maria","Bianchi")
		};
		
		
//		Comparator<Person> cmp = new Comparator<Person>(){
//			public int compare(Person a, Person b){
//				return a.getId() - b.getId();
//			}
//		};
		//Comparator<Person> cmp = (a,b) -> a.getId() - b.getId();
		Comparator<Person> cmp = (a,b) -> a.getLast().compareTo( b.getLast() );
		Arrays.sort(pa, cmp);
		
		cmp = builder( new LastNameExtractor() );
		Arrays.sort(pa , cmp);
		
		Arrays.sort( pa, builder( Person::getLast ) );
		
		
		
		Arrays.sort( pa, Comparator.comparing(Person::getLast)); // Java 8+
		
		// Pre-Java 8
		Arrays.sort(pa, new Comparator<Person>(){
			public int compare(Person a, Person b){
				return a.getLast().compareTo(a.getLast());
			}
		});
		
		
		Arrays.sort( pa, Comparator.
				comparing(Person::getLast).
						thenComparing(Person::getFirst) ); // Java 8+

		
	}
	
	static <T,R extends Comparable<R>> Comparator<T> builder( Function<T,R> g){
		
		return (a,b) -> g.apply(a).compareTo(g.apply(b)); 
		
	}
	
	static class LastNameExtractor implements Function<Person,String>{
		public String apply(Person p){
			return p.getLast();
		}
	}
	
	
	

}
