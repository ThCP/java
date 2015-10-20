package example_comparator;

import java.util.Comparator;

public class StudentNumericIdComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		return s1.getNumericId()-s2.getNumericId();
	}
	
}
