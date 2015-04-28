package examples;

public class StringSorter extends Sorter {
	void compare (Object a, Object b){
		String sa = (String) a;
		String sb = (String) b;
		return sa.compareTo (sb) > 0;
	}
}
