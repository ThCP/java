package examples.stream;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class StringStream {

	public static void main(String[] args) {
		String txt = "A comparison function, which imposes a total ordering on some collection of objects. Comparators can be passed to a sort method (such as Collections.sort or Arrays.sort) to allow precise control over the sort order. Comparators can also be used to control the order of certain data structures (such as sorted sets or sorted maps), or to provide an ordering for collections of objects that don't have a natural ordering."+
				"The ordering imposed by a comparator c on a set of elements S is said to be consistent with equals if and only if c.compare(e1, e2)==0 has the same boolean value as e1.equals(e2) for every e1 and e2 in S."+
				"Caution should be exercised when using a comparator capable of imposing an ordering inconsistent with equals to order a sorted set (or sorted map). Suppose a sorted set (or sorted map) with an explicit comparator c is used with elements (or keys) drawn from a set S. If the ordering imposed by c on S is inconsistent with equals, the sorted set (or sorted map) will behave \"strangely.\" In particular the sorted set (or sorted map) will violate the general contract for set (or map), which is defined in terms of equals."+
				"For example, suppose one adds two elements a and b such that (a.equals(b) && c.compare(a, b) != 0) to an empty TreeSet with comparator c. The second add operation will return true (and the size of the tree set will increase) because a and b are not equivalent from the tree set's perspective, even though this is contrary to the specification of the Set.add method."+
				"Note: It is generally a good idea for comparators to also implement java.io.Serializable, as they may be used as ordering methods in serializable data structures (like TreeSet, TreeMap). In order for the data structure to serialize successfully, the comparator (if provided) must implement Serializable."+
				"Unlike Comparable, a comparator may optionally permit comparison of null arguments, while maintaining the requirements for an equivalence relation."+
				"This interface is a member of the Java Collections Framework.";
		
		String[] txta = txt.split("[ \t\n().,'\"]+");
		
		// Imperative style
//		LinkedList<String> words = new LinkedList<>();
//		for(String w : txta) words.add(w);
//		Collections.sort(words);
//		List<String> firstThree = words.subList(0, 3);
//		for(String w : firstThree){
//			System.out.println(w);
//		}
//		
//		// Functional (stream) style
//		Stream.of(txta)   // source operation
//				.sorted().limit(3) // intermediate/transformation operations
//				.forEach(System.out::println); // terminal operation
//		
		
		Stream.of(txta).filter( word -> {return word.length() >= 3;}  )
		.distinct()
		.sorted( comparingInt(String::length))
		.forEach(System.out::println);

		Stream.of(txta)
		//.map( word -> new Integer( word.length() ) )
		//.map( String::length )
		.mapToInt( String::length )
		.forEach(System.out::println);
		
		int max = Stream.of(txta)
		.mapToInt( String::length )
		
//		.reduce( (a,b) -> Math.max(a, b) ).getAsInt();
		.reduce( Math::max ).getAsInt();  // Optional because no identity

		 max = Stream.of(txta)
		.mapToInt( String::length )
//		.reduce( (a,b) -> Math.max(a, b) ).getAsInt();
		.reduce(0, Math::max );

		
		
		int fullLength = Stream.of(txta)
		.mapToInt( String::length )
		.reduce(0, (a,b) -> a+b );
		
		
		Optional<String> tenCharWord = Stream.of(txta)
				.filter( w -> w.length()>10).findFirst();
				//.findFirst( (String w) -> (w.length() > 10) );
//		
//		String s = tenCharWord.get();
//		String s1 = tenCharWord.orElse("<no word found>");
//		if( tenCharWord.isPresent() ){
		
//		Collector<String,AverageAcc,Integer> avgAcc = 
//				new Collector<String,AverageAcc,Integer>(){
//					@Override
//					public Supplier<AverageAcc> supplier() {
//						// TODO Auto-generated method stub
//						return null;
//					}
//					@Override
//					public BiConsumer<AverageAcc, String> accumulator() {
//						// TODO Auto-generated method stub
//						return null;
//					}
//					@Override
//					public BinaryOperator<AverageAcc> combiner() {
//						// TODO Auto-generated method stub
//						return null;
//					}
//					@Override
//					public Function<AverageAcc, Integer> finisher() {
//						// TODO Auto-generated method stub
//						return null;
//					}
//					@Override
//					public Set<java.util.stream.Collector.Characteristics> characteristics() {
//						// TODO Auto-generated method stub
//						return null;
//					}
//			
//		};
			
		Collector<String,AverageAcc,Integer> avgCollector = 
				Collector.of(
						//() -> new AverageAcc(),
						AverageAcc::new,   // supplier
						
						//(acc, w) -> acc.addWord(w),
						AverageAcc::addWord,  // accumulator
						
						//(a,b) -> { a.combineWith(b); return a; }, // combiner
						AverageAcc::merge , // combiner
						
						//a -> a.average()
						AverageAcc::average // finisher
						
						
						);
		
		int averageWord = Stream.of(txta).collect(avgCollector);
		
		
		long numWords = Stream.of(txta).collect(counting());
		
		
		double averageWordD = Stream.of(txta).collect(averagingInt(String::length));
		
		Collection<String> longWords = Stream.of(txta)
				.filter( w -> w.length()>10)
				.distinct()
				.sorted(comparing(String::length).reversed())
				.collect(toCollection(LinkedList::new));
				
		Set<String> longWordsSet = Stream.of(txta).collect(toSet());  // Note: set implementation is chosen by API
		
		Stream.of(txta).distinct()
			.sorted(comparing(String::length))
			.limit(10)
			.collect(joining(", "));
		
		Map<Integer,List<String>> byLength =
		Stream.of(txta).distinct()
			.collect(groupingBy(String::length));
		// equivalent to
		//Map<Integer,List<String>> byLength =
		Stream.of(txta).distinct()
			.collect(groupingBy(String::length,toList())); // Note: list implementation is chosen by API


		Map<Integer,Long> wordFreq =
		Stream.of(txta).distinct()
			.collect(groupingBy(String::length, counting()));

		Set<Entry<Integer,Long>> s = wordFreq.entrySet();
		
		s.stream().sorted(comparing(Entry<Integer,Long>::getValue).reversed())
	.forEach( e -> System.out.println("There are " + e.getValue() + 
									  " words  with length " + e.getKey() ));
		
		
		Stream.of(txta).distinct()
		.collect(groupingBy(String::length, counting()))
		.entrySet().stream()
		.sorted(comparing(Entry<Integer,Long>::getValue).reversed())
		.forEach( e -> System.out.println("There are " + e.getValue() + 
										  " words  with length " + e.getKey() ));
		
		//System.out.println(wordFreq);
		
	}

	static class AverageAcc {
		private int length;
		private int count;
		public void addWord(String w){
			this.length += w.length();
			count++;
		}
		public int average(){
			return length / count;
		}
		public void combineWith(AverageAcc other){
			this.length+=other.length;
			this.count+=other.count;
		}
		public AverageAcc merge(AverageAcc other){
			this.length+=other.length;
			this.count+=other.count;
			return this;
		}
	}
	
	
	
	
	
}
