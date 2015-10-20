package example_comparator;

import java.util.Comparator;

public class StudentIdComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return new Integer (o1.getId()) - new Integer (o2.getId());
	}
	
}
