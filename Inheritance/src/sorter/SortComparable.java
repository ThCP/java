package sorter;

public abstract class SortComparable {
	
	
	  public static void sort(Object v[]){
	    for(int i=1; i<v.length; ++i)
	      for(int j=1; j<v.length; ++j){
	    	    Comparable first = (Comparable) v[j-1];
	        if( first.compareTo( v[j]) > 0){
	          Object o=v[j];
	          v[j]=v[j-1]; v[j-1]=o;
	        }
	      }
	  }
	 
}
