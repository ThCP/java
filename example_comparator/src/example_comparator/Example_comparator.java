package example_comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Example_comparator {

	public static void main(String[] args) {
			
			List<Student> students;
			
			students = new LinkedList<> ();

			Student s = new Student ("Mario", "Rossi", "123", new Integer( "123" ));
			students.add(s);
			s = new Student ("Giorgio", "Rossi", "134", new Integer( "134" ));
			students.add(s);
			s = new Student ("Ottavio", "Oddone", "543", new Integer( "543" ));
			students.add(s);
			s = new Student ("Luciano", "Reda", "144", new Integer( "144" ));
			students.add(s);
			s = new Student ("Carlo", "Conti", "814", new Integer( "814" ));
			students.add(s);
			s = new Student ("Lorenzo", "Carlozzi", "234", new Integer( "234" ));
			students.add(s);
			s = new Student ("Paolo", "Fianti", "555", new Integer( "555" ));
			students.add(s);
			/**
			 * What follows is the long version, which requires new additional classes.
			 */
			// Sort wrt numeric id
			Collections.sort(students, new StudentNumericIdComparator().reversed()); // reverse sorted
			// Sort wrt string id
			Collections.sort(students, new StudentIdComparator());
			// I shuffle the collection
			Collections.shuffle(students);
			
			/**
			 * Here I have instead the short version, in which the classes are defined inside the sort declaration.
			 */
			// Reverse sorting by numericId
			Collections.sort(students, new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o1.getNumericId()-o2.getNumericId();
				}
			}.reversed());
			
			/**
			 * The following comparator compares first by surname and then by name
			 */
			// Students sorted by surname, then by name
			Collections.sort (students, new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o1.getSurname().compareTo(o2.getSurname());
				}
			}.thenComparing(new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o1.getName().compareTo(o2.getName());
				}
			}));
			
			/**
			 * The following comparator employs lambda functions when implementing the comparator
			 */
			// Students sorted by numericId
			Collections.sort(students, (a,b) -> a.getNumericId() - b.getNumericId());
			for (Student i : students) {
				System.out.println (i.toString());
			}
			// Students sorted by id
			Collections.sort(students, (a,b) -> a.getId().compareTo(b.getId()));
			for (Student i : students) {
				System.out.println (i.toString());
			}
			// Students sorted by surname
			Collections.sort(students, (a,b) -> a.getSurname().compareTo(b.getSurname()));
			for (Student i : students) {
				System.out.println (i.toString());
			}
			/**
			 * The following comparators employ the comparator factory method
			 */
			// Sorting using funct. interfaces by id
			Collections.sort(students, comparing( Student::getName ).thenComparing( Student::getSurname));
			Collections.shuffle(students);
			// Sorting using the compareTo method in Student class
			
			System.out.println("Sort using compareTo in student");
			Collections.sort(students);
			for (Student i : students) {
				System.out.println (i.toString());
			}
			Collections.shuffle(students);
			Collections.sort(students, (a,b) -> ((Student) a).getNumericId() - ((Student) b).getNumericId());
			Collections.sort(students, (a,b) -> a.getNumericId() - b.getNumericId());
//			
			System.out.println ("###################################");
			Collections.sort(students, comparing ( a -> ((Student) a).getSurname()).thenComparing((a,b) -> ((Student) a).getName().compareTo(((Student) b).getName())));
			for (Student i : students) {
				System.out.println (i.toString());
			}
			
			Student max = students.stream().collect(maxBy( (a,b) -> a.getNumericId() - b.getNumericId())).get();
			System.out.println(max);
			
	}	
}
