package sorter;

import java.util.Arrays;
import java.util.Comparator;

import company.Employee;

public class ExampleComparable {

	public static void main(String[] args) {
		
		Employee[] employees = { new Employee("John Smith",20000),
								 new Employee("Mary Black",30000),
								 new Employee("Mario Rossi",15000)
		};
		
		System.out.println(Arrays.toString(employees));

		//SortComparable.sort(employees);
		Arrays.sort(employees);
		
		System.out.println(Arrays.toString(employees));
		
//		Arrays.sort(employees,new Comparator(){
//			public int compare(Object a, Object b){
//				Employee e1 = (Employee) a;
//				Employee e2 = (Employee) b;
//				return e1.getName().compareTo(e2.getName());
//		}
//		});

		Arrays.sort(employees, (a,b) -> {
				Employee e1 = (Employee) a;
				Employee e2 = (Employee) b;
				return e1.getName().compareTo(e2.getName());
		}
		);

		System.out.println(Arrays.toString(employees));

	}

}
