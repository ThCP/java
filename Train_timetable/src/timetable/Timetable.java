package timetable;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class Timetable {
	
	private Map<String, Path> paths = new HashMap<> ();
	
	
	  public Path createPath(String code, String category) {
		  Path pp = new Path (code, category);
		  paths.put(code, pp);
		  
		  return pp;
	  }
	
	  public Collection getPaths() {
	    return paths.values();
	  }
	
	  public Path getPath(String code) {
	    return paths.get(code);
	  }
	
	  public Train newTrain(String code, int day, int month, int year) 
	  	throws InvalidPath {
		  
		  if (! paths.containsKey(code)) throw new InvalidPath();
		  
		  Train t = new Train(code, day, month, year, paths.get(code));
			paths.get(code).addTrain(t);  
			  return t;
		  
	  }
	
	  public List getTrains() {
		 return paths.values().stream().flatMap(s -> s.getTrains().stream()).collect(toList());
	  }

}
