package sorter;

public abstract class Sorter {
	  public void sort(Object v[]){
	    for(int i=1; i<v.length; ++i)
	      for(int j=1; j<v.length; ++j){
	        if(compare(v[j-1],v[j])>0){
	          Object o=v[j];
	          v[j]=v[j-1]; v[j-1]=o;
	        }
	      }
	  }
	  abstract int compare(Object a, Object b);
}
