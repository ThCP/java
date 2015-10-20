package trail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class Trail {
	private int bib = 0; // progressive number of runners
	private List<Runner> runners = new ArrayList<>(); // I use arraylist because it is more efficient since we know which id to access
	private LinkedHashMap<String,Location> path = new LinkedHashMap<>(); // In this way I have the linked list so that the entries
																		 // are in order of introduction but I can use the map's properties
																		 // of accessing  an entry using its key (String in this case)
	private Map<String,Delegate> delegates = new HashMap<>(); 
	

    public int newRunner(String name, String surname){
    	   Runner r = new Runner(++bib,name,surname); // constructor of runner 
    	   runners.add(r); // add the runner to the runner list
        return bib; // return the bib to the caller
    }
    
    public Runner getRunner(int bibNumber){
        return runners.get(bibNumber-1); // the -1 is due to the fact that the bib's start from 1 instead of 0
    }
    
    public Collection<Runner> getRunner(String surname){ // get all the runners having the given surname
//        return runners.stream()
//        		.filter( r -> r.getSurname().equals(surname))
//        		.collect(toList())
//        		;
        // OR
        ArrayList<Runner> result = new ArrayList<>();
        for( Runner r : runners){
        	
        	  if( r.getSurname().equals(surname)){
        		  result.add(r);
        	  }
        }
        return result;
    }
    
    public List<Runner> getRunners(){ // return all the runners (no filter)
        return new ArrayList<>(runners);
    }

    public List<Runner> getRunnersByName(){ 
    		List<Runner> result = new ArrayList<>(runners);
    		Collections.sort( // import the needed methods
    					result, // array to be sorted
    				comparing(Runner::getSurname) // compare first by surname
    				.thenComparing(Runner::getName) // then by name
    				);
        return result;
    }
    
    public void addLocation(String location){ // add a new location to the trail
        Location l = new Location(location,path.size()); // the size is the position of the location in the trail
        
        path.put(location, l); // add the location to the path	
    }
//    public void addLocation(String name, double lat, double lon, double elevation){
//        
//    }

    public Location getLocation(String nameOfLocation){ // get location by name
        return path.get(nameOfLocation);
    }

    public List<Location> getPath(){ // get the whole path
        //return new ArrayList<>(path.values());
    		return path.values().stream().collect(toList()); // I convert it to a list
    }
    
    public void newDelegate(String name, String surname, String ssn){ //add a new delegate
        Delegate d = new Delegate(name,surname,ssn);
        delegates.put(ssn, d); 
    }

    /**
     * Format: "Surname, Name, SSN"
     * @return
     */
    public List<String> getDelegates(){
        return delegates.values().stream()
        		.sorted() // sort the stream
        		.map(Delegate::toString) // map every delegate to its toString version
        		.collect(toList()); // collect the resulting strings in a list
    }
    

    public void assignDelegate(String location, String delegate) throws TrailException {
       Delegate d = delegates.get(delegate); // fetch the delegate
       Location l = path.get(location); // fetch the location
       
       if(d==null || l == null){ // verify if the values exist
    	   	throw new TrailException(); // if not, throw exception
       }
       
       l.assignDelegate(d); // else assign the delegate to the location
    }
 
    public List<String> getDelegates(String location){ // find the delegates given a location
        Location l = path.get(location); 

        return l.getDelegates().stream()
        		//.sorted(comparing(Delegate::getSurame).thenComparing(Delegate::getName))
        		.sorted() // sort using the compareTo overridden in class Delegate
        		.map(Delegate::toString) // map to the toString version
        		.collect(toList());
    }
    
    public long recordPassage(String delegate, String location, int bibNumber) throws TrailException {
    		long timestamp = System.currentTimeMillis();	
    		Delegate d = delegates.get(delegate);
    		Location l = path.get(location);
    	    if(l==null || d==null) throw new TrailException(); // delegate or location not existing

    	    if(bibNumber<1 || bibNumber>runners.size())  throw new TrailException(); // invalid bib
    		Runner r = runners.get(bibNumber-1); // fetch the runner

    	    if(!l.hasDelegate(d)) throw new TrailException(); // delegate not assigned to the current location

    	    Passage p = new Passage(timestamp,d,l,r); // record passage
    	    
    	    l.addPassage(p); // add passage to location
    	    r.setLastPassage(p); // set last passage to runner
    	    
        return timestamp; // return timestamp to caller
    }
    
    public long getPassTime(String position, int bibNumber) throws TrailException { // find the last passage in a location performed by a runner identified by the bib
    	    Location l = path.get(position); // get the needed position
    	    
    	    if(l==null || bibNumber < 1 || bibNumber > runners.size()) throw new TrailException(); // the bib isn't valid
        return l.getPassage(bibNumber); // return the last passage done by the runner
    }
    
    public List<Runner> getRanking(String location){ // call the getRanking for the wanted location
	    Location l = path.get(location);
        return l.getRanking(); // returns a list of runners
    }

    public List<Runner> getRanking(){ // get the overall ranking
        return runners.stream()
        		.filter(Runner::hasLastPassage) // takes only the runners who have a last passage in the location
        		.sorted(comparing(Runner::lastLocationOrderNumber).reversed() // compiler can get lost
        				.thenComparing(Runner::lastPassageTime))
        		// OR
        		.sorted(comparing(Runner::lastLocationOrderNumber,reverseOrder())  // easier for the compiler
        				.thenComparing(Runner::lastPassageTime)
        				)
        		.collect(toList())
        		;
    }
}
