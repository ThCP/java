package taxi;

import java.util.Collection;
import java.util.LinkedList;

public class Taxi implements InfoI {

	private String id;
	public String getId() {
		return id;
	}

	private boolean isAvailable;
	private Passenger passenger;
	private Collection<Trip> trips = new LinkedList<>();
	private Trip lastTrip;
	
	public Collection<Trip> getTrips() {
		return trips;
	}

	public Taxi(String id) {
		this.id = id;
		this.isAvailable = true;
	}
	
	public String toString(){
		return id;
	}
	
	public void beginTrip(Place dest) {
		Trip t = new Trip (passenger.getPlace(), dest);
		trips.add(t);
		lastTrip = t;
	}
	
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
		isAvailable = false;
	}

	public void terminateTrip(){
		passenger.setUserPosition(lastTrip.getDestination());
		isAvailable = true;
	}

	public boolean isAvailable(){
		return isAvailable;
	}

	@Override
	public int compareTo(InfoI arg0) {
		int diff = this.trips.size() - ((Taxi) arg0).getTrips().size();
		if (diff != 0) return diff;
		else return this.id.compareTo(arg0.getId());
	}

	@Override
	public int getValue() {
		return trips.size();
	}
}
