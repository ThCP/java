package taxi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;


public class TaxiCompany {
	
	private Map<String, Taxi> taxiList = new LinkedHashMap<>();
	private int lostCalls;
	
	public void addTaxi(String id) throws InvalidTaxiName {
		if (taxiList.containsKey(id)) throw new InvalidTaxiName();
		Taxi t = new Taxi(id);
		taxiList.put(id, t);
	}
	
	public Collection<Taxi> getAvailable() {
		return taxiList.values().stream().filter(Taxi::isAvailable).collect(toList());
	}

	public Taxi callTaxi(Passenger p) {
		Taxi t = taxiList.values().stream().filter(Taxi::isAvailable).findFirst().orElse(null);
		
		if (t == null) lostCalls += 1;
		else {
			t.setPassenger(p);
		}
		return t;
	}
	
	public List<Trip> getTrips(String id) throws InvalidTaxiName{
		if (!taxiList.containsKey(id)) throw new InvalidTaxiName();
		return taxiList.get(id).getTrips().stream().collect(toList());
	}
	
	public int getLostTrips(){
		return lostCalls;
	}
	
	public ArrayList<InfoI> statsTaxi() {
		return new ArrayList<InfoI> (taxiList.values().stream().sorted().collect(toList()));
	}
	
	public ArrayList<InfoI> statsDistricts() {
		Map <String, Integer> tripsPerDistrict = new HashMap<>();
		taxiList.values().stream().flatMap(t -> t.getTrips().stream()).collect(groupingBy(d -> d.getDestination(),counting()));
		return null;
	}
}
