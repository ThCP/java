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
	private int bib = 0;
	private List<Runner> runners = new ArrayList<>();
	private LinkedHashMap<String,Location> path = new LinkedHashMap<>();
	private Map<String,Delegate> delegates = new HashMap<>();
	

    public int newRunner(String name, String surname){
    	   Runner r = new Runner(++bib,name,surname);
    	   runners.add(r);
        return bib;
    }
    
    public Runner getRunner(int bibNumber){
        return runners.get(bibNumber-1);
    }
    
    public Collection<Runner> getRunner(String surname){
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
    
    public List<Runner> getRunners(){
        return new ArrayList<>(runners);
    }

    public List<Runner> getRunnersByName(){
    		List<Runner> result = new ArrayList<>(runners);
    		Collections.sort(result,
    				comparing(Runner::getSurname).thenComparing(Runner::getName)
    				);
        return result;
    }
    
    public void addLocation(String location){
        Location l = new Location(location,path.size());
        
        path.put(location, l);
    }
//    public void addLocation(String name, double lat, double lon, double elevation){
//        
//    }

    public Location getLocation(String nameOfLocation){
        return path.get(nameOfLocation);
    }

    public List<Location> getPath(){
        //return new ArrayList<>(path.values());
    		return path.values().stream().collect(toList());
    }
    
    public void newDelegate(String name, String surname, String ssn){
        Delegate d = new Delegate(name,surname,ssn);
        delegates.put(ssn, d);
    }

    /**
     * Format: "Surname, Name, SSN"
     * @return
     */
    public List<String> getDelegates(){
        return delegates.values().stream().sorted().map(Delegate::toString).collect(toList());
    }
    

    public void assignDelegate(String location, String delegate) throws TrailException {
       Delegate d = delegates.get(delegate);
       Location l = path.get(location);
       
       if(d==null || l == null){
    	   	throw new TrailException(); 
       }
       
       l.assignDelegate(d);
    }
 
    public List<String> getDelegates(String location){
        Location l = path.get(location);

        return l.getDelegates().stream()
        		//.sorted(comparing(Delegate::getSurame).thenComparing(Delegate::getName))
        		.sorted()
        		.map(Delegate::toString)
        		.collect(toList());
    }
    
    public long recordPassage(String delegate, String location, int bibNumber) throws TrailException {
    		long timestamp = System.currentTimeMillis();
    		Delegate d = delegates.get(delegate);
    		Location l = path.get(location);
    	    if(l==null || d==null) throw new TrailException();

    	    if(bibNumber<1 || bibNumber>runners.size())  throw new TrailException();
    		Runner r = runners.get(bibNumber-1);

    	    if(!l.hasDelegate(d)) throw new TrailException();

    	    Passage p = new Passage(timestamp,d,l,r);
    	    
    	    l.addPassage(p);
    	    r.setLastPassage(p);
    	    
        return timestamp;
    }
    
    public long getPassTime(String position, int bibNumber) throws TrailException {
    	    Location l = path.get(position);
    	    
    	    if(l==null || bibNumber < 1 || bibNumber > runners.size()) throw new TrailException();
        return l.getPassage(bibNumber);
    }
    
    public List<Runner> getRanking(String location){
	    Location l = path.get(location);
        return l.getRanking();
    }

    public List<Runner> getRanking(){
        return runners.stream()
        		.filter(Runner::hasLastPassage)
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
