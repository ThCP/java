package examples.stream;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import students.Course;
import students.Student;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;
import static students.Student.*;


public class StudentStreams {
	List<Student> students;

	public StudentStreams() {
		students = new LinkedList<>();
		// Setup a sample of data structures
		students.add(new Student(100,"John","Smith",M));
		students.add(new Student(101,"Mary","Johnson",F));
		students.add(new Student(201,"Andrea","Rossi",M));
		students.add(new Student(202,"Giulia","Ferrari",F));
		students.add(new Student(301,"Wei","Wang",M));
		students.add(new Student(302,"Fang","Li",F));

		Course c1 = new Course("02JEY","Object-Oriented Programming");
		Course c2 = new Course("02LAS","Databases");
		Course c3 = new Course("02HGK","Computer Networks");

		students.stream().forEach( s -> s.enroll(c1));
		// OR
//		for(Student s : students){
//			s.enroll(c1);
//		}
		students.stream().limit(3).forEach( s -> s.enroll(c2));
		students.stream().skip(2).limit(3).forEach( s -> s.enroll(c3));
	}
	
	public StudentStreams(List<Student> students) {
		this.students = students;
	}

	/*------------- Assignments --------------*/
	
	// retrieve all the female students
	public Collection<Student> femaleStudents(){
		return students.stream()				// take all the students from "students"
				.parallel()
				.filter( Student::isFemale ) // keep only the female students
				.collect(toList())		   // collect them into a list
				;
		// OR 
//		LinkedList<Student> result = new  LinkedList<>();
//		for(Student s : students){
//			if( s.isFemale() ){
//				result.add(s);
//			}
//		}
//		return result;
	}

	// retrieve all students whose first name is "John"
	public Collection<Student> studentsNamedJohn(){
		Predicate<Student> isNamedJohn = s -> s.getFirst().equals("John");
		
		return students.stream()
				//.filter( s -> s.getFirst().equals("John") )
				.filter( isNamedJohn )
				.collect(toList())
				;
			// OR
//			Stream<Student> johnStream = students.stream().filter(isNamedJohn);
//			return johnStream.collect(toList());
			// OR
//			LinkedList<Student> res = new LinkedList<>();
//			students.stream().parallel().filter(isNamedJohn)
//			.forEach( res::add );   // side effect
//			return res;
	}

	// retrieve the collection (unique) last names of students
	public Collection<String> lastNames(){
		return students.stream()
				.map(Student::getLast)
//				.distinct()
//				.collect(toList())
				// OR
				.collect(toSet())
				// OR
//				.collect(toList()).stream()
//				.collect(toSet())
				;
	}
	
	// retrieve the lengths of the first names of students
	public Collection<Integer> namesLengths(){
		return students.stream()
//				.map(Student::getFirst)
//				.map(String::length)
					// OR
				.map( s -> s.getFirst().length() )
				.collect(toList())
				;
	}

	// retrieve the students that are enrolled to 2 or more courses
	public Collection<Student> studentsWithTwoEnrollments(){
		return students.stream()
				.filter( s -> s.enrolledIn().size() >= 2 )
				.collect(toList())
				;
	}

	// find the number of students that are enrolled to 2 or more courses
	public int numStudentWithTwoEnrollments(){
		return (int) students.stream()
				.filter( s -> s.enrolledIn().size() >= 2 )
				.count()
//				.collect(counting()).intValue()
				;
	}
	
	// get all the courses the students are enrolled to 
	public Collection<Course> coursesWithStudents(){
		return students.stream()   // Stream<Student>
//				.map(Student::enrolledIn) // Stream<Collection<Course>>
//				.flatMap(Collection::stream) // Stream<Course>
				// OR
				.flatMap( s -> s.enrolledIn().stream() )
				.collect(toSet());
	}
	
	// get all the unique names of the courses, the students are enrolled to 
	public Collection<String> nameCoursesWithStudents(){
		return students.stream()   // Stream<Student>
//				.map(Student::enrolledIn) // Stream<Collection<Course>>
//				.flatMap(Collection::stream) // Stream<Course>
				// OR
				.flatMap( s -> s.enrolledIn().stream() )
				.map(Course::getTitle)
				.collect(toSet());
	}
	
	// get the maximum length of students last names
	public int maxLastNameLength(){
		return students.stream()
//				.map( s -> s.getLast().length())
//				.max( (a,b) -> a-b).orElse(0)
				.mapToInt( s -> s.getLast().length() )
				.max().orElse(0)
				;
	}
	
	// retrieve the student with the longest last name
	public Optional<Student> studentWithLongestName(){
		return students.stream()
				.max(comparing( s -> s.getLast().length()))
				;

//		return Optional.empty();
	}
	
	// get a string with the list of sorted first names of all male students separated by ","   
	public String maleNames(){
		return null;
	}
	
	// group students by gender
	public Map<Student.Gender,List<Student>> studentsByGender(){
		return null;
	}
	
	// find number of students by gender
	public Map<Student.Gender,Long> numStudentsByGender(){
		return null;
	}
	
	// group students by number of attending courses
	public Map<Long,List<Student>> studentsByNumCourses(){
		return null;
	}

	// return a ranking of students by number of attended courses
	// the students have to be sorted alphabetically
	// the map associate a rank to the list of students with that rank.
	// Note: if two Student share the rank 1, the next Student will have rank 3
	public Map<Long,List<Student>> studentsRankByCourse(){
		return null;
	}

}
