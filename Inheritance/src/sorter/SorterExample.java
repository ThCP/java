package sorter;

import java.util.Arrays;

public class SorterExample {

	public static void main(String[] args) {
		Sorter ssrt = new StringSorter();

		String[] v={"g","t","h","n","j","k"};
		
		System.out.println("Before: " + Arrays.toString(v));
		ssrt.sort(v);
		System.out.println("After: " + Arrays.toString(v));
		
		
	}

}
