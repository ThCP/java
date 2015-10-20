package taxi;

public class Trip {
	
	private Place departure, destination;
	
	public Trip(Place departure, Place destination) {
		super();
		this.departure = departure;
		this.destination = destination;
	}
	
	public Place getDeparture() {
		return departure;
	}

	public void setDeparture(Place departure) {
		this.departure = departure;
	}

	public Place getDestination() {
		return destination;
	}

	public void setDestination(Place destination) {
		this.destination = destination;
	}

	public String toString() {
		return departure.toString() + "," + destination.toString();
	}

	
}
